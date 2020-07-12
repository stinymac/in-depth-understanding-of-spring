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

import org.mac.sf.ioc.dependency.Person;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther mac
 * @date 2020-07-11 20:46
 */
public class TypeSafeDependencyLookup {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 TypeSafeDependencyLookup 作为配置类（Configuration Class）
        applicationContext.register(TypeSafeDependencyLookup.class);
        // 启动应用上下文
        applicationContext.refresh();

        try {
            applicationContext.getBean(Person.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        ObjectFactory<Person> personObjectFactory = applicationContext.getBeanProvider(Person.class);
        try {
            personObjectFactory.getObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //  类型安全的
        ObjectProvider<Person> personObjectProvider = applicationContext.getBeanProvider(Person.class);
        System.out.println("Person:"+personObjectProvider.getIfAvailable());//null
        // ObjectProvider<T> extends ObjectFactory<T>, Iterable<T>
        personObjectProvider.forEach(p -> System.out.println("p："+p));

        ListableBeanFactory beanFactory = applicationContext;

        System.out.println("Person map : "+beanFactory.getBeansOfType(Person.class));

        applicationContext.close();
    }
}
