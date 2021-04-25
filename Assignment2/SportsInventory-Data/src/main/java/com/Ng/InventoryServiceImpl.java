package com.Ng;

import com.Ng.Entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(InventoryService.class)
public class InventoryServiceImpl implements InventoryService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clearList() {
        Query deleteFromInv = em.createNamedQuery("Inventory.clearAll");
        deleteFromInv.executeUpdate();

    }

    @Override
    public List<Inventory> getInventoryList() {
        List<Inventory> InventoryList = em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList();
        return InventoryList.stream().sorted().collect(Collectors.toList());

    }

    @Override
    public void addToList(Inventory inventory) {

    }

    @Override
    public void removeFromList(Inventory inventory) {

    }
}
