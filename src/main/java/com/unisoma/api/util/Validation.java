package com.unisoma.api.util;

public class Validation {

    private static int[] weightCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    public static String formatCPF(String cpf) {
        return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private static int calculateDigit(String str, int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    public static boolean isCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11))
            return false;
        Integer digit1 = calculateDigit(cpf.substring(0, 9), weightCPF);
        Integer digit2 = calculateDigit(cpf.substring(0, 9) + digit1, weightCPF);
        return cpf.equals(cpf.substring(0, 9) + digit1.toString() + digit2.toString());
    }

}
