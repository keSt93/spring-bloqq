package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.repository.BloqqRepository;
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

    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView m = new ModelAndView("home");

        m.addObject("lastBloqqPost", bloqqRepository.findFirstByOrderByIdDesc());
        return m;
    }

}
