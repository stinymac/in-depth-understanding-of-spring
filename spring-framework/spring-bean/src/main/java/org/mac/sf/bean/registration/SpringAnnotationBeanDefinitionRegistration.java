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

import org.mac.sf.bean.Person;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @auther mac
 * @date 2020-07-07 20:29
 */
// 3. 通过 @Import 来进行导入
@Import(SpringAnnotationBeanDefinitionRegistration.Configuration.class)
public class SpringAnnotationBeanDefinitionRegistration {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //applicationContext.register(Configuration.class);
        applicationContext.register(SpringAnnotationBeanDefinitionRegistration.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registryBeanDefinition(applicationContext, "mac-user",Person.class);
        // 2. 非命名 Bean 的注册方法
        registryBeanDefinition(applicationContext,Person.class);

        applicationContext.refresh();

        // 按照类型依赖查找
        System.out.println("Configuration 类型的所有 Beans" + applicationContext.getBeansOfType(Configuration.class));
        System.out.println("Person 类型的所有 Beans" + applicationContext.getBeansOfType(Person.class));

        applicationContext.close();

    }

    //2. 通过 @Component 方式
    @Component
    public static class Configuration{
        // 1. 通过 @Bean 方式定义
        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        @Bean(name = {"person", "person-spike"})
        public Person person() {
            Person person = new Person();
            person.setName("Alex");
            person.setAge(35);
            return person;
        }
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass){
        registryBeanDefinition(registry,null,beanClass);
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry, String beanName,Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder
                .addPropertyValue("name", "spike")
                .addPropertyValue("age", 30);

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }
}
