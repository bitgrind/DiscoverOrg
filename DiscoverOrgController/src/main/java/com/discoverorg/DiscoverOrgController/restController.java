package com.discoverorg.DiscoverOrgController;

import com.discoverorg.DiscoverOrgController.Classes.SmartFridgeComponent;
import com.discoverorg.DiscoverOrgController.Models.FridgeItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class restController {

    @Autowired
    SmartFridgeComponent SmartFridgeComponent;

    @CrossOrigin
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(long itemType, String itemUUID, String name, Double fillFactor) {
        SmartFridgeComponent.handleItemAdded(itemType, itemUUID, name, fillFactor);
        return "Item Added";
    }

    @CrossOrigin
    @RequestMapping(value = "/removeItem", method = RequestMethod.GET)
    @ResponseBody
    public String removeItem() {
        return "remove";
    }

    @CrossOrigin
    @RequestMapping(value = "/getItemsInFridge", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<FridgeItem> getItemsInFridge() {
        return SmartFridgeComponent.getItemsInFridge();
    }

    @CrossOrigin
    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    @ResponseBody
    public Object[] getItems(Double fillAmount) {
        Object[] rtnObj;
        rtnObj = SmartFridgeComponent.getItems(fillAmount);
        return rtnObj;
    }

    @CrossOrigin
    @RequestMapping(value = "/forgetItem", method = RequestMethod.GET)
    @ResponseBody
    public String forgetItem() {
        return "forget";
    }
}
