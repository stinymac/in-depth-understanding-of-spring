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

package org.mac.sf.bean.definition;

import org.mac.sf.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @auther mac
 * @date 2020-07-07 19:37
 */
public class SpringBeanDefinitionCreation {

    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        beanDefinitionBuilder
                .addPropertyValue("name","jerry")
                .addPropertyValue("age",18);
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinitionForJerry = beanDefinitionBuilder.getBeanDefinition();
        System.out.println("beanDefinition(jerry)："+beanDefinitionForJerry);

        GenericBeanDefinition beanDefinitionForTom = new GenericBeanDefinition();
        beanDefinitionForTom.setBeanClass(Person.class);

        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //propertyValues.addPropertyValue("name", "tom");
        //propertyValues.addPropertyValue("age", 18);
        propertyValues
                .add("name", "tom")
                .add("age", 18);
        // 通过 set MutablePropertyValues 批量操作属性
        beanDefinitionForTom.setPropertyValues(propertyValues);

        System.out.println("beanDefinition(tom)："+beanDefinitionForTom);
    }
}
