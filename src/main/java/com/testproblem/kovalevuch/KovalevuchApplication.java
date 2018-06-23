package com.testproblem.kovalevuch;

import com.testproblem.kovalevuch.controllers.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KovalevuchApplication implements CommandLineRunner {

    @Autowired
    private MainMenu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(KovalevuchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainMenu.menu();
    }
}
