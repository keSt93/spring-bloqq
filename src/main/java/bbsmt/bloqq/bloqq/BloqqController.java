package bbsmt.bloqq.bloqq;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BloqqController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user/{name}")
    public String userpage(@PathVariable String name) {
        return "Moin "+name;
    }

}