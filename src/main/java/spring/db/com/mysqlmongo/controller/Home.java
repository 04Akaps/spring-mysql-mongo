package spring.db.com.mysqlmongo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Home {

    @GetMapping("/")
    public String home() {
        return "welcome to Board Server";
    }
}
