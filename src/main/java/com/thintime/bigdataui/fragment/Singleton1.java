package com.thintime.bigdataui.fragment;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Thintime
 * @create 2020/4/27
 * @desc todo 碎片化知识2：单例模式，运行时只有一个实例
 * @note 懒汉模式：事先不初始化，需要时才实例化，默认非线程安全
 * @note 饿汉模式：类加载时就进行单例对象的创建，利用了ClassLoader.loadClass方法的线程安全机制(synchronized)
 */
public class Singleton1 {
    private static Singleton1 s;
    private Singleton1() {}

    public static synchronized Singleton1  getInstance() {
        if (s==null) {
            s=new Singleton1();
        }
        return s;
    }

}

class Singleton2 {
    //编译器可能进行指令重排，s2就会在未初始化前对其赋值，这样其他人获取的对象可能是残缺的
    private volatile static Singleton2 s2;
    private Singleton2(){}

    public static Singleton2 getInstance() {
        //双重校验锁：减小锁的粒度，其中volatile避免指令重排
        if (s2==null) {
            synchronized (Singleton2.class) {
                if (s2==null) {
                    s2=new Singleton2();
                }
            }
        }
        return s2;
    }
}

enum Singleton3 {
    /**
     * @desc 枚举实现线程安全的单例， <p>Singleton3.INSTANCE.getInstance();</p>
     * @note 底层Enum类的成员变量是static类型的，并且在静态代码块中实例化
     * @remark 枚举可以解决反序列化破坏单例的问题，枚举的反序列化不是通过反射实现的
     * @note 普通类的反序列化过程中，会通过反射调用默认构造方法来new对象
     */
    INSTANCE;

    public void getInstance() {
        System.out.println(1);
    }
}

class Singleton4 {
    /**
     * @desc 静态内部类实现线程安全的单例，无需依靠synchronized
     */
    private static class SingletonHolder {
        private static final Singleton4 S = new Singleton4();
    }
    private Singleton4(){}

    public static final Singleton4 getInstance() {
        return SingletonHolder.S;
    }
}

class Singleton5 {
    /**
     * @desc 使用乐观锁CAS实现线程安全的单例，无需依靠synchronized
     * @remark 基于忙等待的算法，没有线程切换和阻塞
     */
    private static final AtomicReference<Singleton5> S = new AtomicReference<>();
    private Singleton5(){}

    public static Singleton5 getInstance() {
        for(;;) {
            Singleton5 singleton = S.get();
            if (singleton != null) {
                return singleton;
            }
            singleton = new Singleton5();
            if (S.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}

class Singleton6 {
    /**
     * @desc 使用ThreadLocal实现线程安全的单例，无需依靠synchronized
     * @note 同步机制仅提供一份变量，让不同线程排队访问，而ThreadLocal为每个线程提供一份变量
     */
    private static final ThreadLocal<Singleton6> S = new ThreadLocal<Singleton6>(){
        @Override
        protected Singleton6 initialValue() {
            return new Singleton6();
        }
    };
    private Singleton6(){}

    public static Singleton6 getInstance() {
        return S.get();
    }
}
