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
@CrossOrigin
public class restController {

    @Autowired
    SmartFridgeComponent SmartFridgeComponent;

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public @ResponseBody String addItem(@RequestBody FridgeItem fridgeItem) {
        SmartFridgeComponent.handleItemAdded(fridgeItem.getItemType(), fridgeItem.getItemUUID(), fridgeItem.getItemName(), fridgeItem.getFillFactor());
        return "Item Added";
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.GET)
    @ResponseBody
    public String removeItem(@RequestParam("itemUUID") String itemUUID) {
        SmartFridgeComponent.handleItemRemoved(itemUUID);
        return "remove";
    }

    @RequestMapping(value = "/getItemsInFridge", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<FridgeItem> getItemsInFridge() {
        return SmartFridgeComponent.getItemsInFridge();
    }

    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<FridgeItem> getItems(@RequestParam("fillFactor") Double fillFactor) {
        return SmartFridgeComponent.getItems(fillFactor);
    }

    @RequestMapping(value = "/forgetItem", method = RequestMethod.GET)
    @ResponseBody
    public String forgetItem(@RequestParam("itemUUID") Long itemUUID) {
        SmartFridgeComponent.forgetItem(itemUUID);
        return "Item Forgot";
    }
}
