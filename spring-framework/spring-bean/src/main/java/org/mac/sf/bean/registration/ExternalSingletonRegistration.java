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

package org.mac.sf.bean.registration;

import org.mac.sf.bean.DefaultPersonFactory;
import org.mac.sf.bean.PersonFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther mac
 * @date 2020-07-08 20:57
 */
public class ExternalSingletonRegistration {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建一个外部 personFactory 对象
        PersonFactory personFactory = new DefaultPersonFactory();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        // 注册外部单例对象
        singletonBeanRegistry.registerSingleton("personFactory", personFactory);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 personFactory
        PersonFactory personFactoryLookup = applicationContext.getBean("personFactory", PersonFactory.class);
        System.out.println("personFactory  == personFactoryLookup : " + (personFactory == personFactoryLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }
}
