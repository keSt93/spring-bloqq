package bbsmt.bloqq.bloqq.controller;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.Kommentar;
import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import bbsmt.bloqq.bloqq.repository.KommentarRepository;
import bbsmt.bloqq.bloqq.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;

@Controller
public class KommentarController {

    @Autowired
    private KommentarRepository kommentarRepository;

    @Autowired
    private BloqqRepository bloqqRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/kommentarAction/{id}")
    public String saveKommentar(String kommentarText, @PathVariable int id, Principal principal) {
        Kommentar kommentar = new Kommentar();
        User user = userRepository.findByUserNameEquals(principal.getName());
        BloqqPost bloqqPost = bloqqRepository.findById(id);
        if(StringUtils.isNotEmpty(kommentarText)) {
            kommentar.setKommentar(kommentarText);
            kommentar.setBloqqPost(bloqqPost);
            kommentar.setCreationDate(new Date());
            if(user != null) {
                kommentar.setUser(user);
            } else {
                user = userRepository.findById(-1);
                kommentar.setUser(user); //wenn ein Gast postet, nehme -1 als id
            }
            kommentarRepository.save(kommentar);
        }
        return "redirect:/id{id}";
    }

}
