package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("theresa may first elected")) {
            return "2016";
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

        if (query.toLowerCase().contains("multiplied")) {
            query = query.substring(query.indexOf(":"));
            int total = 1;
            String numsplit = query.replaceAll("[^0-9]+", ";");
            numsplit=numsplit.substring(1);
            String[] array  = numsplit.split(";");


            for(String s: array) {
                int number = Integer.valueOf(s);
                total *= number;
            }
            return Integer.toString(total);
        }

        if (query.toLowerCase().contains("both a square and a cube")) {
            query = query.substring(query.lastIndexOf(":")+2);
            List<String> list = Arrays.asList(query.split(", "));
            for(String s: list) {
                int number = Integer.valueOf(s);
                double sqrt = Math.sqrt(number);
                double cbrt = Math.cbrt(number);
                if(Math.pow((int) sqrt,2) == number) {
                    if(Math.pow((int)cbrt,3) == number) {
                        return Integer.toString(number);
                    }
                }
            }
            return "";

        }

        if (query.toLowerCase().contains("are primes")) {
            query = query.substring(query.lastIndexOf(":") + 2);
            List<String> list = Arrays.asList(query.split(", "));
            List<String> output = new ArrayList<>();
            for (String s : list) {
                boolean isPrime = true;
                int number = Integer.valueOf(s);
                for (int divisor = 2; divisor <= number / 2; divisor++) {
                    if (number % divisor == 0) {
                        isPrime = false;
                        break; // num is not a prime, no reason to continue checking
                    }
                }
                if(isPrime) {
                    output.add(Integer.toString(number));
                }

            }
            return output.toString();
        }

        return "";
    }
}
