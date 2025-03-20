package edu.du.sb0320;

import edu.du.sb0320.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Sb0320ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void contextLoads() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MyUser user = MyUser.builder()
                .name("홍길동")
                .email("hong@gmail.com")
                .build();  // 객체생성
        em.persist(user); // 영속성

        em.getTransaction().commit();
        em.close();
    }

    @Test
    void test1() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MyUser user = MyUser.builder()
                .id(1L)
                .name("홍길")
                .email("hong2@gmail.com")
                .createdAt(LocalDateTime.now())
                .build();
        em.detach(user);
        em.merge(user); // update

//        MyUser user = em.find(MyUser.class, 1);
//        System.out.println(user);

        em.getTransaction().commit();
        em.close();
    }

}
