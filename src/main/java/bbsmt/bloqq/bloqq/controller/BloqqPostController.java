package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.Kommentar;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.models.PageModel;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.KommentarRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/bp")
public class BloqqPostController {

    @Autowired
    private BloqqRepository bloqqRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KommentarRepository kommentarRepository;


    @GetMapping("/all")
    public ModelAndView bloqqPosts(){
        ModelAndView modelAndView = new ModelAndView("multipleBloqqPosts");

        Iterable<BloqqPost> bloqqlist = bloqqRepository.findAllByOrderByCreateDateDesc();
        modelAndView.addObject("bloqqlist",bloqqlist);
        return modelAndView;
    }

    @GetMapping("/id/{id}")
    public ModelAndView singleBloqqPost(@PathVariable int id){

        BloqqPost currentBloqqPost = bloqqRepository.findById(id);
        User currentUser = currentBloqqPost.getUser();
        ModelAndView modelAndView = new ModelAndView("singleBloqqPost");
        modelAndView.addObject("kommentarObject", new Kommentar());
        modelAndView.addObject("bloqqpost", currentBloqqPost);
        modelAndView.addObject("kommentarListe", kommentarRepository.getAllByBloqqPostOrderByCreationDateDesc(currentBloqqPost));
        modelAndView.addObject("mehrVonUserListe", bloqqRepository.findAllByUserAndIdNotOrderByCreateDateDesc(currentUser,currentBloqqPost.getId()));
        return modelAndView;
    }

    @PostMapping(value = "/postKommentarAction/{bloqqId}")
    private String saveView(Kommentar kommentarObject, Principal currentUser, @PathVariable int bloqqId)  {
        BloqqPost currBloqqPost = bloqqRepository.findById(bloqqId);
        User currUser;
        try {
            currUser = userRepository.findByUserNameEquals(currentUser.getName());
        } catch (Exception x) {
            currUser = userRepository.findById(-1);
            System.out.print("User not found.");
        }


        if(StringUtils.isNotEmpty(kommentarObject.getKommentarText()) && currBloqqPost != null) {
            kommentarObject.setUser(currUser);
            kommentarObject.setKommentarText(kommentarObject.getKommentarText());
            kommentarObject.setCreationDate(new Date());
            kommentarObject.setBloqqPost(currBloqqPost);
            kommentarRepository.save(kommentarObject);
            return "redirect:/bp/id/"+bloqqId;
        } else {
            return "redirect:/";
        }
    }

}
