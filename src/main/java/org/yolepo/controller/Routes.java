package org.yolepo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mjali on 04/11/2016.
 */
@Controller
public class Routes {

    @RequestMapping({
            "/"
    })
    public String index() {
        return "forward:/ErdApp.html";
    }
}
