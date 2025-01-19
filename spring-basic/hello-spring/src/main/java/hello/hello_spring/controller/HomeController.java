package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost:8080에 진입하자마자 홈 띄우기
    public String home() {
        return "home";
    }
}
