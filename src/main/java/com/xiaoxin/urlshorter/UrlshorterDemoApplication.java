package com.xiaoxin.urlshorter;

import com.xiaoxin.urlshorter.utils.IdWorker;
import com.xiaoxin.urlshorter.utils.NumericConvertUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlshorterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlshorterDemoApplication.class, args);
    }


    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

//    @Bean
//    public NumericConvertUtils numericConvertUtils() {
//        return new NumericConvertUtils();
//    }
}
