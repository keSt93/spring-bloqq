package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.forms.UserForm;
import bbsmt.bloqq.bloqq.utils.UserUtils;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/register")
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("registerUser");
        modelAndView.addObject("user", new User());
        return modelAndView;

    }

    @PostMapping(value = "/registerAction")
    private String saveView(User user) {
        if(StringUtils.isNotEmpty(user.getUserName()) && StringUtils.isNotEmpty(user.getPassword())) {
            if(userValidator(user)) {
                Date date = new Date();
                user.setPassword(user.getPassword());
                user.setUserName(user.getUserName());
                user.setCreationDate(new Date());
                userRepository.save(user);
                return "redirect:/register";
            }
            return "redirect:/registerError ";
        }
        return "redirect:/register";
    }

    @GetMapping(value = "/registerError")
    private ModelAndView errorView(){
        ModelAndView modelAndView = new ModelAndView("registerError");
        modelAndView.addObject("error", new String());
        return modelAndView;
    }

    private boolean userValidator(User user) {
        if (userRepository.findUserByUserName(user.getUserName()) == null || StringUtils.isEmpty(userRepository.findUserByUserName(user.getUserName()).toString())) {
            return true;
        }
        return false;
    }
}
