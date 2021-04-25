package com.Ng.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i ORDER BY i.dateUpdated")
@NamedQuery(name = "Inventory.clearAll", query = "DELETE from Inventory")
public class Inventory implements Comparable<Inventory> , Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String name;
    private String sport;
    private int quantity;
    private float pricePerUnit;
    private Date dateUpdated;

    @PrePersist
    void createdAt() {
        this.dateUpdated = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.dateUpdated = new Date();
    }

    public Inventory(long id, String name, String sport, int quantity, float pricePerUnit, Date dateUpdated) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sport='" + sport + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", dateUpdated=" + dateUpdated +
                '}';
    }


    @ManyToOne
    @JoinColumn(name = "id_inventory")
    private Inventory inventory;

    @Override
    public int compareTo(Inventory o) {
        return dateUpdated.compareTo(o.dateUpdated);
    }
}
