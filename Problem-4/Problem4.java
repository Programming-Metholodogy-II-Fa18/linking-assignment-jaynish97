package com.Jaynish;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem4 {
    public String ProblemFourA(String org) {
        int string_length = org.length();
        String reverse = "";
        for (int j = org.length() - 1; j > -1; j--) {
            char ch = org.charAt(j);
            reverse += ch;
        }
        return reverse;
    }
}




