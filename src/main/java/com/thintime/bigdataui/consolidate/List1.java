package com.thintime.bigdataui.consolidate;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Thintime
 * @create 2020/4/28
 * @desc todo 巩固练习1：List坑
 */
@Setter @Getter
public class List1 {
    static String[] arr = {"1", "2", "3"};

    public static void main(String[] args) {
        List<String> list = Arrays.asList(arr);

        /** 坑1
         * @see Arrays#asList(T... a),ArrayList
         * @throws UnsupportedOperationException if <p>list.add("别的元素");</p>
         * @note ArrayList#add等方法来自于AbstractList，而Arrays$ArrayList没有重写父类的方法
         */

        /** 坑2
         * @remark Arrays$ArrayList改动内部元素将会影响原数组
         * @remark List#subList生成新集合也会影响原List
         * @because 新集合底层使用了原List
         */
        list.set(0, "1a");
        System.out.println(Arrays.toString(arr)+"，"+list); //[1a, 2, 3]，[1a, 2, 3]
        //嵌套一层ArrayList进行修复
        List<String> list2 = new ArrayList<>(list);
        list2.set(1, "2a");
        System.out.println(Arrays.toString(arr)+"，"+list2); //[1a, 2, 3]，[1a, 2a, 3]

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);integerList.add(2);integerList.add(3);
        List<Integer> subList = integerList.subList(0, 2); //左闭右开，[1,2]
        subList.set(1,11);
        System.out.println(integerList);

        /** 坑3
         * @throws ConcurrentModificationException if <p>list2.remove(s);</p>
         * @see ArrayList.Itr,ArrayList#remove
         * @because 修改操作会让modCount+1，不等于expectedModCount导致抛出异常
         * @note 不要随便在foreach增加/删除元素
         */
        for (String s : list2) {
            if (s.equals("1a")); //list2.remove(s);
        }
        //进行修复
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String var = it.next();
            if (var.equals("1a")) {
                it.remove();
            }
        }
        list2.removeIf(str -> str.equals("2a"));
        System.out.println(list2);
    }
}