package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.Utils.UserUtils;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/register")
    public String showView(Model model)
    {
        model.addAttribute("registerUser", new User());
        return "registerUser";

    }

    @PostMapping(value = "/registerAction")
    private String saveView(Model model, @ModelAttribute User user) {
        if(StringUtils.isNotEmpty(user.getUserName()) && StringUtils.isNotEmpty(user.getPassword())) {
            user.setUserName(user.getUserName());
            user.setPassword(UserUtils.calcPasswordHash(user.getPassword()));
            userRepository.save(user);
        }

        return "redirect:/";
    }

    @ModelAttribute(value = "User")
    public User getUserInstance() {
        return new User();
    }

}
