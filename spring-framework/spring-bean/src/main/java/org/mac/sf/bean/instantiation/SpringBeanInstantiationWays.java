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

package org.mac.sf.bean.instantiation;

import org.mac.sf.bean.DefaultPersonFactory;
import org.mac.sf.bean.PersonFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @auther mac
 * @date 2020-07-07 21:02
 */
public class SpringBeanInstantiationWays {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        System.out.println(applicationContext.getBean("person-by-static-method"));
        System.out.println(applicationContext.getBean("person-by-instance-method"));
        System.out.println(applicationContext.getBean("person-by-factory-bean"));

        ApplicationContext specialApplicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        //jdkServiceLoader();
        ServiceLoader<PersonFactory> serviceLoader = specialApplicationContext.getBean("personFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);

        AutowireCapableBeanFactory beanFactory = specialApplicationContext.getAutowireCapableBeanFactory();
        PersonFactory personFactory = beanFactory.createBean(DefaultPersonFactory.class);
        System.out.println(personFactory.createPerson());

    }

    public static void jdkServiceLoader() {
        ServiceLoader<PersonFactory> serviceLoader = ServiceLoader.load(PersonFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<PersonFactory> serviceLoader) {
        Iterator<PersonFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            PersonFactory personFactory = iterator.next();
            System.out.println(personFactory.createPerson());
        }
    }
}
