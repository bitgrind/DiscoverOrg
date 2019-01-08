package com.discoverorg.DiscoverOrgController.Objects;

public class fridgeItem {

    String itemUUID;
    String itemType;
    String itemName;
    Double fillFactor;

    public String getItemUUID() {
        return itemUUID;
    }

    public void setItemUUID(String itemUUID) {
        this.itemUUID = itemUUID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
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
