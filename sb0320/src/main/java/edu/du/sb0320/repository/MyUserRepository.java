package edu.du.sb0320.repository;

import edu.du.sb0320.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByName(String name);
    List<MyUser> findMyUserByOrderByNameAsc();
}
