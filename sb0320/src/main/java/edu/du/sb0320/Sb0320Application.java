package edu.du.sb0320;

import edu.du.sb0320.entity.MyUser;
import edu.du.sb0320.repository.MyUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb0320Application {

    @Autowired
    private MyUserRepository myUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(Sb0320Application.class, args);
    }

//    @PostConstruct
    public void init() {
        MyUser myUser = MyUser.builder()
                .email("test1@gmail.com")
                .name("홍길동")
                .build();
        myUserRepository.save(myUser);

         myUser = MyUser.builder()
                .email("test2@gmail.com")
                .name("홍길")
                .build();
        myUserRepository.save(myUser);

         myUser = MyUser.builder()
                .email("test3@gmail.com")
                .name("홍")
                .build();
        myUserRepository.save(myUser);
    }

}
