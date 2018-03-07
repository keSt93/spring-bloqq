package bbsmt.bloqq.bloqq.controller;

import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.models.PageModel;
import bbsmt.bloqq.bloqq.repository.BloqqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/bp")
public class BloqqPostController {

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 1;
    private static final int[] PAGE_SIZES = { 1,2,3 };

    @Autowired
    private BloqqRepository bloqqRepository;


    public BloqqPostController(BloqqRepository bloqqRepository) {
        this.bloqqRepository = bloqqRepository;
    }

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
        return modelAndView;
    }

    @GetMapping("/id/{id}")
    public ModelAndView singleBloqqPost(@PathVariable int id){

        ModelAndView modelAndView = new ModelAndView("singleBloqqPost");

        modelAndView.addObject("bloqqpost",bloqqRepository.findById(id));
        return modelAndView;
    }
}
