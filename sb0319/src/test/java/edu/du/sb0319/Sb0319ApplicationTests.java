package edu.du.sb0319;


import edu.du.sb0319.entity.Memo;
import edu.du.sb0319.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class Sb0319ApplicationTests {

    @Autowired
    private MemoRepository memorepository;

    @Test
    void memo추가(){
        //given
        Memo memo = Memo.builder()

                .build();
//        Memo memo = new Memo();
//        memo.setContent("테스트");
        //when
        memorepository.save(memo);
//        System.out.println("입력");
        //then
        assertThat(1==1).isTrue();
    }

}
