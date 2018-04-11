package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class WriteBloqqPostController {

    @Autowired
    private BloqqRepository bloqqRepository;
    private UserRepository userRepository;

    @GetMapping(value = "/postbloqq")
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("writeBloqqPost");
        modelAndView.addObject("bloqqpost", new BloqqPost());
        return modelAndView;
    }

    @PostMapping(value = "/postbloqqAction")
    private String saveView(BloqqPost bloqqPost)  {
        if(StringUtils.isNotEmpty(bloqqPost.getTitel()) && StringUtils.isNotEmpty(bloqqPost.getContent())) {
            bloqqPost.setTitel(bloqqPost.getTitel());
            bloqqPost.setContent(bloqqPost.getContent());
            bloqqPost.setCreateDate(new Date());
            // TODO: UserID beim Bloqqpost mitsenden ayy
            User uhh = userRepository.findById(22);
            bloqqPost.setUser(uhh);
            bloqqRepository.save(bloqqPost);
            return "redirect:/";
        } else {
            return "ne";
        }
    }
}
