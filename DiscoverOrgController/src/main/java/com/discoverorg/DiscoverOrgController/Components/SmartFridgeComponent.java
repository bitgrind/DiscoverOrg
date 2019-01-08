package com.discoverorg.DiscoverOrgController.Components;

import com.discoverorg.DiscoverOrgController.Interfaces.SmartFridgeManager;
import org.springframework.stereotype.Component;

@Component
public class SmartFridgeComponent implements SmartFridgeManager {

    public void handleItemRemoved( String itemUUID ) {

    }

    public void handleItemAdded( long itemType, String itemUUID, String name, Double fillFactor ) {

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
