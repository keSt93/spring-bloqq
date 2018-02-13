package bbsmt.bloqq.bloqq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BloqqController {

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/user/{name}")
    public String userpage(@PathVariable String name) {
        return "user";
    }

    @RequestMapping("/bloqqpost/{id}")
    public String bloqqpost(@PathVariable int id) {
        return "bloqqpost";
    }

    @RequestMapping("/bloqqposts/{page}")
    public String bloqqposts(@PathVariable int page) {
        if (page <= 0) {
            page = 1;
        }
        return "bloqqpost";
    }
}

