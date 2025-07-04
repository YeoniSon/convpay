package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import com.zerobase.convpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {

//    @Bean
//    public ConveniencePayService conveniencePayService(){
//        return new ConveniencePayService(
//                new HashSet<>(
//                        Arrays.asList(moneyAdapter(), cardAdapter())
//                ),
//                discountByConvenience()
//        );
//    }
//
//    @Bean
//    public CardAdapter cardAdapter() {
//        return new CardAdapter();
//    }
//
//    @Bean
//    public MoneyAdapter moneyAdapter() {
//        return new MoneyAdapter();
//    }
//
//    @Bean
//    public DiscountByConvenience discountByConvenience() {
//        return new DiscountByConvenience();
//    }
    @Autowired
    //resource 적용함
    private ApplicationContext applicationContext;

    public void getResource() throws IOException {
        Resource resource = applicationContext.getResource("myTemplate.txt");

        System.out.println(resource.contentLength() + "");
    }
}
