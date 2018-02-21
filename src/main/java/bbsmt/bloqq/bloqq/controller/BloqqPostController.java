package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bp")
public class BloqqPostController {

    @Autowired
    private BloqqRepository bloqqRepository;


    public BloqqPostController(BloqqRepository bloqqRepository) {
        this.bloqqRepository = bloqqRepository;
    }


    @GetMapping("/")
    public Iterable<BloqqPost> list(){
        return bloqqRepository.findAll();
    }
}
