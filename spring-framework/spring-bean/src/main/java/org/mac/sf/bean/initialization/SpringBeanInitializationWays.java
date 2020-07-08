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

package org.mac.sf.bean.initialization;

import org.mac.sf.bean.DefaultPersonFactory;
import org.mac.sf.bean.PersonFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @auther mac
 * @date 2020-07-07 21:48
 */
public class SpringBeanInitializationWays {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(SpringBeanInitializationWays.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("===============Spring 应用上下文已启动...===============");
        // 依赖查找 UserFactory
        PersonFactory personFactory = applicationContext.getBean(PersonFactory.class);
        System.out.println(personFactory);

        System.out.println("===============Spring 应用上下文准备关闭...===============");
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("===============Spring 应用上下文已关闭...===============");
    }

    @Bean(initMethod = "initPersonFactory", destroyMethod = "doDestroy")
    @Lazy//(value = false)
    public DefaultPersonFactory personFactory() {
        return new DefaultPersonFactory();
    }
}
