package com.prabhu.userservice;

import com.prabhu.userservice.entities.User;
import com.prabhu.userservice.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The id, username, email are all compulsory and unique. But mobile number is unique but not compulsory.
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableCircuitBreaker
//@EnableSwagger2
//@EnableEurekaClient
public class UserServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

    @Autowired
    UserRepo repo;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("Prabhu");
        user1.setLastName("Madipalli");
        user1.setUsername("prabhumns");
        user1.setAccessType("Admin");
        user1.setEmail("prabhumns123@gmail.com");
        user1.setMobileNumber("9791168059");
        user1.setConfirmed(false);
        user1.setPassword("hello");

        repo.save(user1);

    }
}
