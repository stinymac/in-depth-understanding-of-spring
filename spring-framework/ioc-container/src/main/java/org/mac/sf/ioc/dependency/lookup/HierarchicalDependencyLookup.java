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

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther mac
 * @date 2020-07-09 22:09
 */
public class HierarchicalDependencyLookup {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 HierarchicalLookup 作为配置类（Configuration Class）
        applicationContext.register(HierarchicalDependencyLookup.class);

        ConfigurableListableBeanFactory configurableListableBeanFactory = applicationContext.getBeanFactory();

        System.out.println("当前 BeanFactory :["+configurableListableBeanFactory+"] 的父 " +
                "BeanFactory :["+configurableListableBeanFactory.getParentBeanFactory()+"]");

        configurableListableBeanFactory.setParentBeanFactory(initParentBeanFactory());

        System.out.println("当前 BeanFactory :["+configurableListableBeanFactory+"] 的父 " +
                "BeanFactory :["+configurableListableBeanFactory.getParentBeanFactory()+"]");

        applicationContext.refresh();

        System.out.println("当前 BeanFactory : ["+configurableListableBeanFactory+"] 是否包含 : " +
                "[beanName = user] 的Bean?"+configurableListableBeanFactory.containsLocalBean("user"));

        System.out.println("当前 BeanFactory : ["+configurableListableBeanFactory+"]  的父 BeanFactory : ["
                +configurableListableBeanFactory.getParentBeanFactory()+" ]是否包含 : " +
                "[beanName = user] 的Bean?"+((HierarchicalBeanFactory)configurableListableBeanFactory.getParentBeanFactory()).containsLocalBean("user"));

        System.out.println("当前 BeanFactory : ["+configurableListableBeanFactory+"] 向上查找->是否包含 : " +
                "[beanName = user] 的Bean?"+containsBean(configurableListableBeanFactory,"user"));

        applicationContext.close();
    }

    public static boolean containsBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName){
        BeanFactory parentBeanFactory = hierarchicalBeanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory beanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            return containsBean(beanFactory,beanName);
        }
        return hierarchicalBeanFactory != null && hierarchicalBeanFactory.containsLocalBean(beanName);
    }

    public static BeanFactory initParentBeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");

        return factory;
    }
}
