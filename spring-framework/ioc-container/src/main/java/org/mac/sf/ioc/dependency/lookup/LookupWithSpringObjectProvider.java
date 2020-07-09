/*
 *          (          (
 *          )\ )  (    )\   )  )     (
 *  (  (   (()/( ))\( ((_| /( /((   ))\
 *  )\ )\   ((_))((_)\ _ )(_)|_))\ /((_)
 * ((_|(_)  _| (_))((_) ((_)__)((_|_))
 * / _/ _ \/ _` / -_|_-< / _` \ V // -_)
 * \__\___/\__,_\___/__/_\__,_|\_/ \___|
 *
 * 东隅已逝，桑榆非晚。(The time has passed,it is not too late.)
 * 虽不能至，心向往之。(Although I can't, my heart is longing for it.)
 *
 */

package org.mac.sf.ioc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @auther mac
 * @date 2020-07-09 21:41
 */
public class LookupWithSpringObjectProvider {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 LookupWithSpringObjectProvider 作为配置类（Configuration Class）
        applicationContext.register(LookupWithSpringObjectProvider.class);
        // 启动应用上下文
        applicationContext.refresh();

        String s = lookupByObjectProvider(applicationContext,String.class);

        System.out.println("s:"+s);

        applicationContext.close();
    }

    public static <T> T lookupByObjectProvider(ApplicationContext applicationContext,Class<T> classType) {
        ObjectProvider<T> objectProvider = applicationContext.getBeanProvider(classType);
        return objectProvider.getObject();
    }

    @Bean
    public String helloWorld(){
        return "Hello World!";
    }
}
