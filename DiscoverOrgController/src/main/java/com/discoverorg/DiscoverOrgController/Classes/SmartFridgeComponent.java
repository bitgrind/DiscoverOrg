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
    public ArrayList<Long> forgetArray = new ArrayList<>();

    public void handleItemRemoved( String itemUUID ) {
        System.out.println("Item UID");
        System.out.println(itemUUID);

        ArrayList<FridgeItem> newFrideArray = new ArrayList<>();

        for (int i = 0; i < fridgeArray.size(); i++) {
            System.out.println("Array loop");
            if (!fridgeArray.get(i).getItemUUID().equals(itemUUID)) {
                System.out.print("Remove Item");
                newFrideArray.add(fridgeArray.get(i));
            }
        }

        fridgeArray = newFrideArray;
    }

    public void handleItemAdded(long itemType, String itemUUID, String itemName, Double fillFactor) {

        FridgeItem newItem = new FridgeItem(itemType, itemUUID, itemName, fillFactor);
        fridgeArray.add(newItem);
    }

    public ArrayList<FridgeItem> getItemsInFridge() {
        return fridgeArray;
    }

    public ArrayList<FridgeItem> getItems( Double fillFactor ) {
        ArrayList<FridgeItem> rtnList = new ArrayList<>();
        System.out.print("Fill Factor");
        System.out.print(fillFactor);

        for (int i = 0; i < fridgeArray.size(); i++) {
            if (fridgeArray.get(i).getFillFactor() < fillFactor && !forgetArray.contains(fridgeArray.get(i).getItemType())) {
                rtnList.add(fridgeArray.get(i));
            }
        }

        return rtnList;
    }

    public Double getFillFactor(long itemType) {
        Double averageFillFactor = 0.0;
        int averageFillFactorCount = 0;

        for (int i = 0; i < fridgeArray.size(); i++) {
            if (fridgeArray.get(i).getItemType() == itemType) {
                averageFillFactor += fridgeArray.get(i).getFillFactor();
                averageFillFactorCount ++;
            }
        }

        return averageFillFactor/averageFillFactorCount;
    }

    public void forgetItem(long itemType) {
        forgetArray.add(itemType);
    }

}
