package com.company.utils;

//Class to pretty-print.
public class PrintFormatter {

    public void formatText(int len, String input) {
        String padded = String.format("%-" + (len - 1) + "s", input);
        System.out.println(padded + "#");
    }
}
