package com.fastcampus.ch2.di4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

//@SpringBootApplication // 은 아래 3개 애너테이션을 붙인 것과 동일

@SpringBootConfiguration // @Configuration과 동일
////@EnableAutoConfiguration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Main.class, args);
        System.out.println("ac = " + ac);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames); // 빈 목록이 담긴 배열을 정렬
        Arrays.stream(beanDefinitionNames) // 배열을 스트림으로 전환
                .forEach(System.out::println); // 스트림의 요소를 하나씩 꺼내서 출력


    }

    @Bean
    MyBean myBean() {
        return new MyBean();
    }
}


class MyBean {}