package com.develogical;

import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("what is your name")) {
            return "Jigsaw";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            query = query.substring(query.lastIndexOf(":")+2);
            List<String> list = Arrays.asList(query.split(", "));
            int max = 0;
            for(String s: list) {
                int number = Integer.valueOf(s);
                max = Math.max(max, number);
            }
            return Integer.toString(max);
        }

        if (query.toLowerCase().contains("plus")) {
            query = query.substring(query.indexOf(":"));
            int total = 0;
            String numsplit = query.replaceAll("[^0-9]+", ";");
            numsplit=numsplit.substring(1);
            String[] array  = numsplit.split(";");


//            List<String> list = Arrays.asList(query.split(", "));
            int max = 0;
            for(String s: array) {
                int number = Integer.valueOf(s);
                total += number;
            }
            return Integer.toString(total);
        }

        return "";
    }
}
