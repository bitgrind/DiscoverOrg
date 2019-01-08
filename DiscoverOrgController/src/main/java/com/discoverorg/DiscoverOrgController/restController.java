package com.discoverorg.DiscoverOrgController;

import com.discoverorg.DiscoverOrgController.Interfaces.SmartFridgeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @Autowired
    SmartFridgeManager SmartFridge;

    @RequestMapping("/addItem")
    public String addItem() {
        return "added";
    }

    @RequestMapping("/removeItem")
    public String removeItem() {
        return "remove";
    }

    @RequestMapping("/getItems")
    public String getItem() {
        return "List of All Items";
    }

    @RequestMapping("/forgetItem")
    public String forgetItem() {
        return "forget";
    }
}
