package com.thintime.bigdataui.consolidate;

/**
 * @author Thintime
 * @create 2020/4/29
 * @desc todo 巩固练习3：常用Java类
 */
public class Wrapper1 {

    public static void wrapper() {
        Integer a=100;Integer b=100; //自动装箱，基于Integer#valueOf()
        Integer a1=200;Integer a2=200;
        Integer m=new Integer(5); Integer n=new Integer(5); //手动装箱
        System.out.println(m==n); //false

        /**
         * @parse 编译优化为Integer.valueOf(100);
         * @note 如果valueOf(int i)中的i值在[-128,127]会直接从缓存中返回，否则就new对象
         */
        System.out.println((a==b)+","+(a1==a2)); //true,false

        //先自动拆箱m.intValue，相减后再装箱
        m=m-1;n=n-1;
        System.out.println(m==n); //true

        /**
         * @note 对于Integer类型只有==和!=比较引用，其他导致拆箱
         * @if <p>Integer i=new Integer(0);Integer j=new Integer(0);</p>
         *     循环输出0000
         */
        Integer i=0;Integer j=0;
        while (i<=j&i!=j) {
            System.out.println("0000");
        }
    }

    public static void main(String[] args) {
        String s1 = new String("abc");String s1a = new String("abc");
        String s2 = "abc";String s2a = "ab"+"c";
        String s3 = "ab"; String s3a = s3 + "c";//传进String对象
        //对象值比较最好调用equals()方法，因为==会比较其引用。
        System.out.println(s1==s1a); //false
        System.out.println((s1=="abc")+","+(s2==s2a)); //false,true
        System.out.println((s2a==s3a));//false
        wrapper();
        operator();
    }

    public static void operator() {
        /**
         * @throws NullPointerException if <p>Integer result=flag?a*b:c;</p>
         * @because a*b是int类型，c因为类型不一致会强制拆箱为int类型
         */
        Integer a=1;Integer b=2;
        Integer c=null;Boolean flag=false;
        Integer result = flag ? a * b : (c==null?0:1);
    }
}
