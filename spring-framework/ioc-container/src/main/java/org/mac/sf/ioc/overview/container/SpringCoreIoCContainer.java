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

package org.mac.sf.ioc.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @auther mac
 * @date 2020-07-06 21:25
 */
public class SpringCoreIoCContainer {

    public static void main(String[] args) {

        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);

        String location = "classpath:META-INF/dependency-lookup-context.xml";
        int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);

        System.out.println("XmlBeanDefinitionReader load bean definitions count:"+beanDefinitionCount);

        System.out.println(listableBeanFactory.getBean("user"));
    }
}
