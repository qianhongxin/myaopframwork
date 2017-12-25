package my.aop;

import my.aop.Advice;

import java.lang.reflect.Method;

/**
 * Created by Red on 2017/12/25.
 */
public class MyAdvice implements Advice {

    @Override
    public void beforeMethod(Method method) {
        System.out.println(method.getName() + "方法开始执行");
    }

    @Override
    public void afterMethod(Method method) {
        System.out.println(method.getName() + "方法执行结束了");
    }
}
