package com.fastcampus.ch2.di3;


import com.fastcampus.ch2.di3.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Map;

@Component
class Car {
//    @Resource(name="engine")
    @Inject // @Autowired와 거의 같음. required=false
    Engine engine;
//    @Autowired
    @Resource(name="door")
    Door door;

//    public Car() {}
//
//    @Autowired
//    public Car(Engine[] engine, Door door) {
//        this.engine = engine;
//        this.door = door;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
//@Component
class Engine {}

//@Component
//class SuperEngine extends Engine {}

@Component
class TurboEngine extends Engine {}

@Component
class Door {}

public class Main {
    public static void main(String[] args) {
        // AC를 생성 - AC의 설정파일은 AppConfig.class 자바설정
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = (Car)ac.getBean("car");
        System.out.println("car = " + car);

    }
}
