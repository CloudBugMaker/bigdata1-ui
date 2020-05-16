package com.thintime.bigdataui.consolidate;

import lombok.Data;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Thintime
 * @create 2020/4/29
 * @desc todo 巩固练习2：TreeSet
 */
@Data
public class Set1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /**
                 * o1一直为A
                 * @return o2-o1
                 */
                return -o1.compareTo(o2);
            }
        });
        set.add("A"); //65
        set.add("G"); //71
        set.add("E"); //69
        set.add("C"); //67
        for (String s : set) {
            //按照Ascii值降序：(G E C A)
            System.out.println(s);
        }
    }
}
