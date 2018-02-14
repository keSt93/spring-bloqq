package bbsmt.bloqq.bloqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/bloqqpost/{id}")
public class BloqqPostController {

    public String bloqqpost(@PathVariable int id) {
        return "bloqqpost";
    }

}
