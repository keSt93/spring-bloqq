package bbsmt.bloqq.bloqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

}
