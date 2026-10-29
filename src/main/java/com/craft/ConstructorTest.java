
package com.craft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("constructorConfig.xml");

        ConstructorStudent student =
                context.getBean("constructorStudent", ConstructorStudent.class);

        System.out.println(student);

        context.close();
    }
}
