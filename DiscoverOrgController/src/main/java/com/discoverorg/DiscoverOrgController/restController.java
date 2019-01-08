package com.discoverorg.DiscoverOrgController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
