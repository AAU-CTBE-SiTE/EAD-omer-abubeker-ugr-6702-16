
package com.craft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beansConfig.xml");

        // Singleton test
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);

        System.out.println("SINGLETON TEST");
        System.out.println("Same object? " + (student1 == student2));

        // Prototype test
        Student prototype1 =
                context.getBean("prototypeStudent", Student.class);
        Student prototype2 =
                context.getBean("prototypeStudent", Student.class);

        System.out.println("\nPROTOTYPE TEST");
        System.out.println("Same object? " + (prototype1 == prototype2));

        context.close();
    }
}
