package com.thintime.bigdataui.fragment;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Thintime
 * @create 2020/5/18
 * @desc switch VS if
 * @note 使用Oracle的JMH框架，即Java微基准测试套件
 */
@BenchmarkMode(Mode.AverageTime) //测试完成时间
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2,time = 1,timeUnit = TimeUnit.SECONDS) //预热2轮，每次1s
@Measurement(iterations = 5,time = 1,timeUnit = TimeUnit.SECONDS) //测试5轮，每次1s
@Fork(1) //fork 1个线程
@State(Scope.Thread) //每个测试线程一个实例
public class Conditionals {
    static Integer _num = 9;

    public static void main(String[] args) throws RunnerException {
        //启动基准测试
        Options opt = new OptionsBuilder().include(Conditionals.class.getSimpleName())
                .output("D:/Test/jmh-switch.log").build();
        new Runner(opt).run();
    }

    @Benchmark
    public void switchTest() {
        int num1;
        switch (_num) {
            case 1:
                num1=1;break;
            case 3:
                num1=3;break;
            case 5:
                num1=5;break;
            case 7:
                num1=7;break;
            case 9:
                num1=9;break;
            default:
                num1=-1;break;
        }
    }

    @Benchmark
    public void ifTest() {
        int num1;
        if (_num==1) {
            num1=1;
        } else if (_num==3) {
            num1=3;
        } else if (_num==5) {
            num1=5;
        } else if (_num==7) {
            num1=7;
        } else if (_num == 9) {
            num1 = 9;
        } else {
            num1=-1;
        }
    }
}
