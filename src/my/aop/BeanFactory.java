package my.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Red on 2017/12/25.
 */
public class BeanFactory {

    Properties props = new Properties();

    public BeanFactory(InputStream ips) {
        try {
            props.load(ips);
        } catch (IOException e) {
            //todo
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        String className = props.getProperty(name);
        Object bean = null;

        try {
            Class clazz = Class.forName(props.getProperty(name));
            bean = clazz.newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(bean instanceof ProxyFactoryBean) {
            Object proxy = null;
            ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;

            try {
                Advice advice = (Advice) Class.forName(props.getProperty(name + ".advice")).newInstance();
                Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
                proxyFactoryBean.setAdvice(advice);
                proxyFactoryBean.setTarget(target);
                proxy = proxyFactoryBean.getProxy();
            }catch (Exception e){
                e.printStackTrace();
            }

            return proxy;
        }
        return bean;
    }

}
