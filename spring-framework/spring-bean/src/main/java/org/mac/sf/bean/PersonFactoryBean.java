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

package org.mac.sf.bean;

import org.mac.sf.bean.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @auther mac
 * @date 2020-07-07 21:24
 */
public class PersonFactoryBean  implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return Person.createPerson();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
