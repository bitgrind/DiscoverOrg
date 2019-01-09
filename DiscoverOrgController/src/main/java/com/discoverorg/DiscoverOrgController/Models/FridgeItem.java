package com.discoverorg.DiscoverOrgController.Models;

public class FridgeItem {

    String itemUUID;
    Long itemType;
    String itemName;
    Double fillFactor;

    public FridgeItem(long itemType, String itemUUID, String itemName, Double fillFactor) {
        itemUUID = itemUUID;
        itemName = itemName;
        itemType = itemType;
        fillFactor = fillFactor;
    }

    public String getItemUUID() {
        return itemUUID;
    }

    public void setItemUUID(String itemUUID) {
        this.itemUUID = itemUUID;
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getFillFactor() {
        return fillFactor;
    }

    public void setFillFactor(Double fillFactor) {
        this.fillFactor = fillFactor;
    }
}
