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

package org.mac.sf.ioc.overview.dependency.injection;

import org.mac.sf.ioc.overview.bean.User;
import org.mac.sf.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @auther mac
 * @date 2020-07-06 20:04
 */
public class SpringIocDependencyInjection {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-injection-context.xml");

        applicationContext.getBean(UserRepository.class).getUsers().forEach(System.out::println);

        //System.out.println(beanFactory.getBean(BeanFactory.class));//NoSuchBeanDefinitionException

        // false
        /**
         * @see org.springframework.context.support.AbstractRefreshableApplicationContext#beanFactory
         * ApplicationContext类含有BeanFactory域
         * 类似代理的方式 @see {@link AbstractApplicationContext#getBean(java.lang.Class)} //return getBeanFactory().getBean(requiredType);
         * 因此BeanFactory是底层的Ioc容器
         *
         * Application在BeanFactory的基础上增加了额外的特性
         *
         * AOP
         * MessageSource
         * ApplicationEvent
         * WebApplication
         *
         * https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/core.html#beans-introduction
         */
        System.out.println(applicationContext.getBean(UserRepository.class).getBeanFactory() == applicationContext);

        // true
        System.out.println(applicationContext.getBean(UserRepository.class).getObjectFactory().getObject() == applicationContext);

        // 容器内建Bean
        System.out.println("build-in bean -> Environment:"+applicationContext.getBean(Environment.class));
    }
}
