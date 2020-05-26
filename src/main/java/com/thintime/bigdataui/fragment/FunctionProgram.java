package com.thintime.bigdataui.fragment;


import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Thintime
 * @create 2020/5/22
 * @desc todo Lambda表达式：JDK1.8借鉴了Scala的函数式编程，返回一个接口{@link FunctionalInterface}
 * @see Runnable 无参数无返回  {@link Consumer}有参数无返回
 * @desc todo 流式编程：数据源、中间操作和终端操作
 */
public class FunctionProgram {
    public static void test1(String str){
        /**
         * @param T {@return R}
         * @see java.util.function.Predicate 有参数返回布尔
         */
        Function<String,String> f1=s -> s.toUpperCase()+"1";
        System.out.println(f1.apply(str)); //获取R值
        System.out.println(f1.compose(f1).apply(str)); //先执行第二个f1
    }

    public static void test2(String str){
        /**
         * 方法引用，对表达式的简写
         * @param 挥霍青春
         * @replace {@code Consumer<String> c1=s -> System.out.println(s);}
         */
        Consumer<String> c1=System.out::println;
        c1.accept(str);

        /**
         * @return 无私奉献
         * @replace {@code Supplier<String> s1=()-> new Person("Lily",22).getName();}
         */
        Supplier<String> s1=new Person("Lily",22)::getName;
        System.out.println(s1.get());
        //无参构造
        Supplier<Person> s2=Person::new;
        System.out.println(s2.get());
        //静态方法
        s1=Person::getNation;
        System.out.println(s1.get());
    }

    public static void test3(){

    }

    public static void main(String[] args) {
        test1("abc");
        test2("hello");
    }
}

@Data
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static String getNation(){
        return "中国";
    }

}
