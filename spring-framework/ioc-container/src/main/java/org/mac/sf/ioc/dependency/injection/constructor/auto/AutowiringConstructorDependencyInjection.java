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

package org.mac.sf.ioc.dependency.injection.constructor.auto;

import org.mac.sf.ioc.dependency.PersonHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @auther mac
 * @date 2020-07-12 12:20
 */
public class AutowiringConstructorDependencyInjection {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String xmlSourceLocation = "classpath:/META-INF/dependency-injection-autowired-with-constructor-context.xml";

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlSourceLocation);

        System.out.println("user holder:"+beanFactory.getBean(PersonHolder.class));
    }
}
