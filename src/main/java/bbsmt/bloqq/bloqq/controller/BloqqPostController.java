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

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 4;
    private static final int[] PAGE_SIZES = { 4,8,12 };

    @Autowired
    private BloqqRepository bloqqRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KommentarRepository kommentarRepository;


    @GetMapping("/all")
    public ModelAndView bloqqPosts(@RequestParam("pageSize") Optional<Integer> pageSize,
                                 @RequestParam("page") Optional<Integer> page){

        ModelAndView modelAndView = new ModelAndView("multipleBloqqPosts");

        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<BloqqPost> bloqqlist = bloqqRepository.findAll( new PageRequest(evalPage, evalPageSize));
        PageModel pager = new PageModel(bloqqlist.getTotalPages(),bloqqlist.getNumber(),BUTTONS_TO_SHOW);
        // add clientmodel
        modelAndView.addObject("bloqqlist",bloqqlist);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
        //add commentz
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
        modelAndView.addObject("mehrVonUserListe", bloqqRepository.findAllByUserOrderByCreateDateDesc(currentUser));
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
