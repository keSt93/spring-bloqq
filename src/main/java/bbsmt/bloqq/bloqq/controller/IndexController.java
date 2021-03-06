package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BloqqRepository bloqqRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView m = new ModelAndView("home");

        User latestUser = userRepository.findFirstUserByOrderByIdDesc();
        Iterable<BloqqPost> mostRecentPost = bloqqRepository.findFirst2ByOrderByIdDesc();

        int allBloqqx = bloqqRepository.countAllBy();
        m.addObject("lastBloqqPost", mostRecentPost);
        m.addObject("lastUser", latestUser);
        m.addObject("allBloqqx", allBloqqx);
        return m;
    }

    @GetMapping("/403")
    public String error403() {
        return "/errors/403";
    }

}
