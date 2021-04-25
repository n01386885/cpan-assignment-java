package com.Ng.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store implements Serializable {

    @Id
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private List<Inventory> list;



}
