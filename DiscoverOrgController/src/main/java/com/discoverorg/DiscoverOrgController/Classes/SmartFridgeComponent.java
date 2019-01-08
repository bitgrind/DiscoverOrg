package com.discoverorg.DiscoverOrgController.Classes;

import com.discoverorg.DiscoverOrgController.Interfaces.SmartFridgeManager;
import com.discoverorg.DiscoverOrgController.Models.FridgeItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SmartFridgeComponent implements SmartFridgeManager {

    public Object[] itemArray;
    public JSONArray fridgeItemArray;
    public ArrayList<FridgeItem> fridgeArray = new ArrayList<>();

    public void handleItemRemoved( String itemUUID ) {

    }

    public void handleItemAdded(long itemType, String itemUUID, String name, Double fillFactor) {
        JSONObject newItem = new JSONObject();
        newItem.put("itemUUID", itemUUID);
        newItem.put("name", name);
        newItem.put("itemType", itemType);
        newItem.put("fillFactor", fillFactor);

        fridgeItemArray.put(newItem);
    }

    public ArrayList<FridgeItem> getItemsInFridge() {

        FridgeItem newItem = new FridgeItem();
        JSONObject rtnObj = new JSONObject();

        newItem.setItemUUID("001");
        newItem.setItemName("Milk");
        newItem.setItemType("Drink");
        newItem.setFillFactor(1.0);


        fridgeArray.add(newItem);


        rtnObj.put("itemList", fridgeArray);

        return fridgeArray;
    }

    public Object[] getItems( Double fillFactor ) {
        Object[] rtnList = new Object[1];

        return rtnList;
    }

    public Double getFillFactor( long itemType ) {
        return 2.1;
    }

    public void forgetItem( long itemType ) {

    }

}
