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

package org.mac.sf.ioc.dependency.injection.constructor.manual;

import org.mac.sf.ioc.dependency.Person;
import org.mac.sf.ioc.dependency.PersonHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @auther mac
 * @date 2020-07-12 11:25
 */
public class AnnotationConstructorDependencyInjection {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 SpringAnnotationConfigApplicationContext 作为配置类（Configuration Class）
        applicationContext.register(AnnotationConstructorDependencyInjection.class);

        String xmlSourceLocation = "classpath:/META-INF/dependency-injection-with-setter-context-person.xml";

        // 注解上下文作为从XML资源中加载Bean的注册容器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlSourceLocation);


        // 启动应用上下文
        applicationContext.refresh();

        System.out.println("user holder:"+applicationContext.getBean(PersonHolder.class));

        applicationContext.close();
    }

    @Bean
    public PersonHolder personHolder(Person person) {
        return new PersonHolder(person);
    }
}
