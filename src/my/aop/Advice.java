package my.aop;

import java.lang.reflect.Method;

/**
 * Created by Red on 2017/12/25.
 */
public interface Advice {
    void beforeMethod(Method method);

    void afterMethod(Method method);
}
