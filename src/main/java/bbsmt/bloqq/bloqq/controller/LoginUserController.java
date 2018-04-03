package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginUserController {

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView m = new ModelAndView("loginUser");
        return m;
    }
}
