package com.Ng;

import com.Ng.Entity.Inventory;

import java.util.List;

public interface InventoryService {

    void clearList();

    List<Inventory> getInventoryList();
    void addToList(Inventory inventory);
    void removeFromList(Inventory inventory);



}
