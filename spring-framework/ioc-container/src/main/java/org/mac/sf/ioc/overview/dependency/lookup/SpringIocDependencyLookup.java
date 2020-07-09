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

package org.mac.sf.ioc.overview.dependency.lookup;

import org.mac.sf.ioc.overview.SpecialUser;
import org.mac.sf.ioc.overview.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.Map;

/**
 * @auther mac
 * @date 2020-07-05 21:20
 */
public class SpringIocDependencyLookup {

    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-lookup-context.xml");

        /**通过名称查找*/
        System.out.println("get user by real-time:"+ lookupByRealTime(factory));
        System.out.println("get user by lazy:"+ lookupByLazy(factory));

        /**通过类型查找*/
        System.out.println("get user by type:"+ lookupByType(factory,User.class));
        System.out.println("get multi users by type:"+ lookupMultiByType(factory,User.class));

        /**通过注解查找*/
        System.out.println("get multi users by annotation type:"+ lookupMultiByAnnotationType(factory,SpecialUser.class));
    }

    private static User lookupByRealTime(BeanFactory factory) {
        return (User) factory.getBean("user");
    }

    private static User lookupByLazy(BeanFactory factory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) factory.getBean("objectFactory");
        return objectFactory.getObject();
    }

    private static User lookupByType(BeanFactory factory,Class<User> userClass) {
        return factory.getBean(userClass);
    }

    private static Map<String,User> lookupMultiByType(BeanFactory factory, Class<User> userClass){
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            return listableBeanFactory.getBeansOfType(userClass);
        }
        return Collections.emptyMap();
    }

    private static  Map<String,Object> lookupMultiByAnnotationType(BeanFactory factory,
                                                                 Class<SpecialUser> annotationClass){
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            return listableBeanFactory.getBeansWithAnnotation(annotationClass);
        }
        return Collections.emptyMap();
    }
}
