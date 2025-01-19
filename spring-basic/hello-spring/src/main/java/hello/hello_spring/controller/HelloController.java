package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "여긴 url/hello를 눌렀을때 인도되는 메소드!!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

}
