package com.kangyi.controller;

//import com.sun.deploy.net.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(path = "/indexMap")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class indexMapController {



    @RequestMapping("/map")
    public String index(HttpSession session, Model model){

        return "jsp/indexMap";
    }

    @RequestMapping("/map1")
    public String inde(HttpSession session, Model model){

        return "jsp/indexMap1";
    }
}
