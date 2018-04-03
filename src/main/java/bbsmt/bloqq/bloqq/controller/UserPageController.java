package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id/{id}")
    public ModelAndView singleUser(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("singleUser");

        User singleUser = new User();
        singleUser = userRepository.findById(id);
        modelAndView.addObject("userProfilePicture", Base64.encodeBase64String(singleUser.getPicture()));
        modelAndView.addObject("user",userRepository.findById(id)) ;
        return modelAndView;
    }
}
