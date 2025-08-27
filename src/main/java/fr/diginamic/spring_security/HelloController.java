package fr.diginamic.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/public")
    public String getHelloPublic() {
        return "Hello public";
    }

    @GetMapping("/hello/private")
    public String getHelloPrivate() {
        return "Hello private";
    }
}
