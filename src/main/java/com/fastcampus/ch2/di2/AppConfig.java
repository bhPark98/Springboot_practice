package com.fastcampus.ch2.di2;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean public Car car() { // 메서드 이름이 빈의 이름
        // map.put("car", new Car());
        // <bean id = "car" class = "com.fastcampus.ch2.Car">
        Car car = new Car();
        return car;
    }

    @Bean public Engine engine() {
        Engine engine = new Engine();
        return engine;
    }

    @Bean public Door door() {
        Door door = new Door();
        return door;
    }


}
