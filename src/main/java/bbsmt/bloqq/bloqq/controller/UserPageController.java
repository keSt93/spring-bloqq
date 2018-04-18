package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.models.PageModel;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloqqRepository bloqqRepository;

    @GetMapping("/id/{id}")
    public ModelAndView singleUser(@PathVariable User id){
        ModelAndView modelAndView = new ModelAndView("singleUser");

        modelAndView.addObject("user",userRepository.findById(id.getId()));
        modelAndView.addObject("userPosts", bloqqRepository.findAllByUserOrderByCreateDateDesc(id));
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView("multipleUser");

        Iterable<User> userList = userRepository.findAllByOrderByCreationDateDesc();
        modelAndView.addObject("userList",userList);

        return modelAndView;
    }
}
