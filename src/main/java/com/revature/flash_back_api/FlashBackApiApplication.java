package com.revature.flash_back_api;

import com.revature.flash_back_api.models.TriviaCard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlashBackApiApplication {

    public static void main(String[] args) {
        TriviaCard triviaCard = new TriviaCard();
        List<String> data = new ArrayList<>();
        data.add("A");
        data.add("B");
        data.add("C");
        System.out.println(data.toString());
        System.out.println(data.get(0));
        data.remove("A");
        data.add(1, "H");

        System.out.println(data.get(1));
        System.out.println(data.toString());

        SpringApplication.run(FlashBackApiApplication.class, args);
    }

}
