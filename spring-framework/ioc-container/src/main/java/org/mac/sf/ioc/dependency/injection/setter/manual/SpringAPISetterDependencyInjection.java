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

package org.mac.sf.ioc.dependency.injection.setter.manual;

import org.mac.sf.ioc.dependency.PersonHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther mac
 * @date 2020-07-12 11:25
 */
public class SpringAPISetterDependencyInjection {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册BeanDefinition
        applicationContext.registerBeanDefinition("userHolder",buildPersonBeanDefinition());

        String xmlSourceLocation = "classpath:/META-INF/dependency-injection-with-setter-context-person.xml";

        // 注解上下文作为从XML资源中加载Bean的注册容器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlSourceLocation);


        // 启动应用上下文
        applicationContext.refresh();

        System.out.println("user holder:"+applicationContext.getBean(PersonHolder.class));

        applicationContext.close();
    }

    public static BeanDefinition buildPersonBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PersonHolder.class);
        beanDefinitionBuilder.addPropertyReference("person","person");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
