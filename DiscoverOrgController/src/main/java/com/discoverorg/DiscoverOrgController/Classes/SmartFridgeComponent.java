package com.discoverorg.DiscoverOrgController.Classes;

import com.discoverorg.DiscoverOrgController.Interfaces.SmartFridgeManager;
import com.discoverorg.DiscoverOrgController.Models.FridgeItem;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
public class SmartFridgeComponent implements SmartFridgeManager {

    public Object[] itemArray;
    public JSONArray fridgeItemArray;
    public ArrayList<FridgeItem> fridgeArray = new ArrayList<>();

    public void handleItemRemoved( String itemUUID ) {
        System.out.println("Item UID");
        System.out.println(itemUUID);

        int arraySize = fridgeArray.size();
        ArrayList<FridgeItem> newFrideArray = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Array loop");
            if (!fridgeArray.get(i).getItemUUID().equals(itemUUID)) {
                System.out.print("Remove Item");
                newFrideArray.add(fridgeArray.get(i));
            }
        }

        fridgeArray = newFrideArray;
    }

    public void handleItemAdded(long itemType, String itemUUID, String itemName, Double fillFactor) {

        FridgeItem newItem = new FridgeItem();

        newItem.setItemUUID(itemUUID);
        newItem.setItemName(itemName);
        newItem.setItemType(itemType);
        newItem.setFillFactor(fillFactor);

        fridgeArray.add(newItem);
    }

    public ArrayList<FridgeItem> getItemsInFridge() {
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
