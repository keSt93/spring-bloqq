package bbsmt.bloqq.bloqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/bloqqposts/{page}")
public class BloqqPostsController {

    public String bloqqposts(@PathVariable int page) {
        if (page <= 0) {
            page = 1;
        }
        return "bloqqpost";
    }
}
