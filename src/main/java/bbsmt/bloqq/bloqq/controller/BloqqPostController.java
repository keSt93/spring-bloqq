package bbsmt.bloqq.bloqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by stein on 14.02.2018.
 */

@Controller
@RequestMapping("/bloqqpost/{id}")
public class BloqqPostController {

    @RequestMapping(value = "/bloqqpost/{id}", method = RequestMethod.GET)
    public String bloqqpost(@PathVariable int id) {

        return "bloqqpost";
    }

}
