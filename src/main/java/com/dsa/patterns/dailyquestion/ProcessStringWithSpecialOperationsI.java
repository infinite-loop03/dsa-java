package com.dsa.patterns.dailyquestion;

public class ProcessStringWithSpecialOperationsI {

    public static void main(String[] args) {
        ProcessStringWithSpecialOperationsI processStringWithSpecialOperationsI = new ProcessStringWithSpecialOperationsI();
        System.out.println(processStringWithSpecialOperationsI.processStr("z*#"));
    }

    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '#') {
                result.append(result);
            } else if (c == '%') {
                result.reverse();
            } else if (c == '*' && !result.isEmpty()) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
