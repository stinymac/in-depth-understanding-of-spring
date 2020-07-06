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

import org.mac.sf.ioc.overview.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther mac
 * @date 2020-07-06 21:40
 */
@Configuration
public class SpringAnnotationConfigApplicationContext {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 SpringAnnotationConfigApplicationContext 作为配置类（Configuration Class）
        applicationContext.register(SpringAnnotationConfigApplicationContext.class);
        // 启动应用上下文
        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));

        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User(1L,"小码哥^^");
        return user;
    }
}
