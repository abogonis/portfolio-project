package com.example.portfolio.util;

import com.example.portfolio.dto.User;
import com.example.portfolio.repository.UserDAO;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void run(ApplicationArguments args) throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:users.csv");
        List<User> users =
                new CsvToBeanBuilder(new InputStreamReader(new FileInputStream(file)))
                        .withSeparator('|')
                        .withType(User.class)
                        .build()
                        .parse();

        users.forEach(
                u -> userDAO.save(u)
        );
    }
}
