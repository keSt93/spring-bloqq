package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.Tags;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.TagRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;

@Controller
public class WriteBloqqPostController {

    @Autowired
    private BloqqRepository bloqqRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping(value = "/postbloqq")
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("writeBloqqPost");
        modelAndView.addObject("bloqqpost", new BloqqPost());
        return modelAndView;
    }

    @PostMapping(value = "/postbloqqAction")
    private String saveView(BloqqPost bloqqPost, Principal currentUser)  {
        if(StringUtils.isNotEmpty(bloqqPost.getTitel()) && StringUtils.isNotEmpty(bloqqPost.getContent())) {
            bloqqPost.setTitel(bloqqPost.getTitel());
            bloqqPost.setContent(bloqqPost.getContent());
            bloqqPost.setCreateDate(new Date());
            bloqqPost.setUser(userRepository.findByUserNameEquals(currentUser.getName()));

            //tag stuff
            Tags potentialTag = tagRepository.findByTagnameEquals(bloqqPost.getTag().getTagname());
            if(potentialTag == null) {
                if(bloqqPost.getTag().getTagname() != "") {
                    Tags newTag = new Tags();
                    newTag.setTagname(bloqqPost.getTag().getTagname());
                    potentialTag = newTag;
                    tagRepository.save(potentialTag);
                } else {
                    potentialTag = tagRepository.findOne(-1);
                }
            }
            bloqqPost.setTag(potentialTag);

            bloqqRepository.save(bloqqPost);
            return "redirect:/";
        } else {
            return "ne";
        }
    }
}
