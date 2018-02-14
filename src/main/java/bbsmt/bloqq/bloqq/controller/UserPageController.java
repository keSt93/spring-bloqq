package bbsmt.bloqq.bloqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/user/{name}")
public class UserPageController {
    public String userpage(@PathVariable String name) {
        return "user";
    }
}
