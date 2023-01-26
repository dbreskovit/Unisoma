package com.unisoma.api.services.implementations;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.models.dtos.response.AdjustmentSalaryDTO;
import com.unisoma.api.models.dtos.response.IncomeTaxDTO;
import com.unisoma.api.models.dtos.EmployeeDTO;
import com.unisoma.api.repositories.AddressRepository;
import com.unisoma.api.repositories.EmployeeRepository;
import com.unisoma.api.services.EmployeeService;

@Service
public class EmployeeImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public String registerEmployee(EmployeeModel employee) {
        if (verifyCpf(employee.getCpf()))
            return "Funcionário já cadastrado";
        if (employee.getSalario() < 0)
            return "Salário inválido";
        employeeRepository.save(employee);
        addressRepository.save(employee.getEndereco());
        return "Funcionário Registrado";
    }

    @Override
    public Object updateEmployeeByCpf(String cpf, EmployeeModel employee) {
        if (verifyCpf(cpf)) {
            EmployeeModel employeeOld = employeeRepository.findByCpf(cpf);
            employeeRepository.deleteById(employeeOld.getId());
            addressRepository.deleteById(employeeOld.getEndereco().getId());
            employeeRepository.save(employee);
            addressRepository.save(employee.getEndereco());
            return "Funcionário Atualizado";
        }
        return "Funcionário não encontrado";
    }

    @Override
    public boolean verifyCpf(String cpf) {
        return employeeRepository.existsByCpf(cpf);
    }

    @Override
    public Object findAll() {
        var employeesModel = employeeRepository.findAll();
        var employeesDto = new ArrayList<EmployeeDTO>();
        for (var employee : employeesModel) {
            var employeeDto = employee.converterToDTO();
            employeesDto.add(employeeDto);
        }
        return employeesDto;
    }

    @Override
    public Object findByCpf(String cpf) {
        if (!verifyCpf(cpf))
            return "Funcionário não encontrado";
        return (employeeRepository.findByCpf(cpf)).converterToDTO();
    }

    @Override
    public Object deleteEmployeeByCpf(String cpf) {
        if (!verifyCpf(cpf))
            return "Funcionário não encontrado";
        addressRepository.deleteById(employeeRepository.findByCpf(cpf).getEndereco().getId());
        employeeRepository.deleteById(employeeRepository.findByCpf(cpf).getId());
        return "Funcionário dispensado";
    }

    @Override
    public Object adjustmentSalary(String cpf) {
        if (!verifyCpf(cpf))
            return "Funcionário não encontrado";
        EmployeeModel employee = employeeRepository.findByCpf(cpf);
        AdjustmentSalaryDTO salaryDTO = new AdjustmentSalaryDTO();
        BeanUtils.copyProperties(employee, salaryDTO);
        Double oldSalary = employee.getSalario();
        Double newSalary = calculateNewSalary(salaryDTO, oldSalary);
        employee.setSalario(newSalary);
        employeeRepository.save(employee);
        return salaryDTO;
    }

    @Override
    public Object incomeTax(String cpf) {
        if (!verifyCpf(cpf))
            return "Funcionário não encontrado";

        EmployeeModel employee = employeeRepository.findByCpf(cpf);
        IncomeTaxDTO incomeTaxDTO = new IncomeTaxDTO();
        incomeTaxDTO.setCpf(employee.getCpf());

        String IRPF = calculateIncomeTax(employee);

        incomeTaxDTO.setImposto(IRPF);

        return incomeTaxDTO;
    }

    private Double calculateNewSalary(AdjustmentSalaryDTO salaryDTO, Double oldSalary) {
        if (oldSalary < 400.01) {
            salaryDTO.setPercentual("15");
        } else if (oldSalary < 800.01) {
            salaryDTO.setPercentual("12");
        } else if (oldSalary < 1200.01) {
            salaryDTO.setPercentual("10");
        } else if (oldSalary < 2000.01) {
            salaryDTO.setPercentual("7");
        } else {
            salaryDTO.setPercentual("4");
        }

        Double percentageNum = Double.parseDouble(salaryDTO.getPercentual());
        Double gainNum = oldSalary * percentageNum / 100;
        Double salaryNum = oldSalary + (oldSalary * percentageNum / 100);

        salaryDTO.setPercentual(salaryDTO.getPercentual() + "%");
        salaryDTO.setGanho("R$ " + String.format("%.2f", gainNum));
        salaryDTO.setSalario("R$ " + String.format("%.2f", salaryNum));

        return salaryNum;
    }

    private String calculateIncomeTax(EmployeeModel employee) {

        String IRPF = "Isento";

        if (employee.getSalario() > 2000.00) {
            IRPF = "R$ " + String.format("%.2f", (employee.getSalario() - 2000) * 0.08);
        }
        if (employee.getSalario() > 3000.00) {
            IRPF = "R$ " + String.format("%.2f", 1000 * 0.08 + ((employee.getSalario() - 3000) * 0.18));
        }
        if (employee.getSalario() > 4500.00) {
            IRPF = "R$ " + String.format("%.2f", 1000 * 0.08 + 1500 * 0.18 + ((employee.getSalario() - 4500) * 0.28));
        }

        return IRPF;
    }
}
