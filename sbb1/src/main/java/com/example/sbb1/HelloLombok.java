package com.example.sbb1;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
    private final String hello;
    private final int lombok;

    public static void main(String args[]){
        HelloLombok helloLombok=new HelloLombok("Hello",5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
