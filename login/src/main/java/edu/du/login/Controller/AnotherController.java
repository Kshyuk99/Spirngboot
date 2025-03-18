package edu.du.login.Controller;


import edu.du.login.Config.spring.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/another")
public class AnotherController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "another/form1";
    }

//    @GetMapping
//    public String home() {
//        return "another/form1";
//    }

    @PostMapping("/step3")
    public String post(RegisterRequest registerRequest, Model model) {
        System.out.println(registerRequest);
//        model.addAttribute("registerRequest", registerRequest);
        return "another/result2";
    }
//    @PostMapping("/step3")
//    public String post(@RequestParam String email,
//                       @RequestParam String name,
//                       @RequestParam String password,
//                       @RequestParam String confirmPassword,
//                       Model model) {
//        System.out.println(email);
//        System.out.println(name);
//        System.out.println(password);
//        System.out.println(confirmPassword);
//        return "another/form2";
//    }
}
