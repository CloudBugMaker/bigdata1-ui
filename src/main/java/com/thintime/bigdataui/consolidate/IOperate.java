package com.thintime.bigdataui.consolidate;

/**
 * @author Thintime
 * @create 2020/5/22
 * @desc i++与++i的区别
 */
public class IOperate {
    public static void main(String[] args) {
        int j=0;
        for (int i = 0; i < 10; i++) {
            /**
             * @result 8 if {@code j=i++;}
             */
            j=j++;
        }
        System.out.println(j); //0

        /**
         * @remark 与局部变量表不同，操作数栈通过压入或弹出来访问数据，而不是通过下标
         * @parse javap -c 反汇编 {@link j=j++}
         * Code:
         *    0: iconst_0   将常数0压入到操作数栈顶
         *    1: istore_1   0弹出并压入到局部变量表中1号槽位，即j=0
         *    2: iconst_0   将常数0压入到操作数栈顶
         *    3: istore_2   0弹出并压入到局部变量表中2号槽位，即i=0
         *    4: iload_2    将2号槽位的元素压入到操作数栈顶(i)
         *   10: iload_1    将1号槽位的元素压入到操作数栈顶(j)
         *   11: iinc  1,1  将1号槽位的元素自增1，j=1
         *   14: istore_1   将操作数栈顶（此时为0）弹出并赋值给1号槽位
         * @result i++先load到操作数栈，然后在局部变量表中自增，但是操作数栈中还是自增前的值
         *         ++i先在局部变量表中自增（innc指令），然后load到操作数栈，所以操作数栈中保存的是自增后的值
         */
    }
}
