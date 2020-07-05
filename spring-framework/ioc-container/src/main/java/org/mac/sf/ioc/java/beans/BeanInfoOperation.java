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

package org.mac.sf.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @auther mac
 * @date 2020-07-05 20:45
 */
public class BeanInfoOperation {

    public static void main(String[] args) throws IntrospectionException {

        Person person = new Person();

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(
                        propertyDescriptor ->{
                            System.out.println(propertyDescriptor);
                            Class<?> propertyType = propertyDescriptor.getPropertyType();
                            String propertyName = propertyDescriptor.getName();
                            if ("age".equals(propertyName)) {
                                propertyDescriptor.setPropertyEditorClass(PersonAgePropertyEditor.class);
                                propertyDescriptor.createPropertyEditor(person);
                            }
                        }
                        );
    }

    static class PersonAgePropertyEditor extends PropertyEditorSupport {

        public void setAsText(String text) throws java.lang.IllegalArgumentException {
           Integer value = Integer.valueOf(text);
           setValue(value);
        }
    }
}
