package edu.du.sb0320.controller;

import edu.du.sb0320.dto.SampleDTO;
import edu.du.sb0320.entity.MyUser;
import edu.du.sb0320.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {
    @Autowired
    private MyUserRepository myUserRepository;

    @GetMapping("/ex1")
    public String ex1(Model model) {
//        MyUser myUser = myUserRepository.findById(1L).get();
        MyUser myUser = myUserRepository.findByName("홍");
        log.info("사용자 정보: {}", myUser);

        model.addAttribute("name1", "hong");
        model.addAttribute("text", "one");
        model.addAttribute("myUser", myUser);
        return "sample/ex1";
    }

    @GetMapping("/ex2")
    public String ex2(Model model) {
//        List<MyUser> list2 = myUserRepository.findAll();
        List<MyUser> list2 = myUserRepository.findMyUserByOrderByNameAsc();
        model.addAttribute("list2", list2);


        List<SampleDTO> list = IntStream.rangeClosed(1,5)
                .asLongStream().mapToObj(i -> {
                    SampleDTO sampleDTO = SampleDTO.builder()
                            .id(i)
                            .name("테스트"+i)
                            .age(20+i)
                            .build();
                    return sampleDTO;
                }).collect(Collectors.toList());
//        List<SampleDTO> list = new ArrayList<>();
//        SampleDTO dto = new SampleDTO(1, "홍길동", 24);
//        list.add(dto);
//         dto = new SampleDTO(2, "홍길", 27);
//        list.add(dto);
        log.info(list.toString());
        model.addAttribute("list", list);
        return "sample/ex2";
    }
}
