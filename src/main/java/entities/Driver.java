/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author Mkhansen
 */
@Entity
@NamedQuery(name = "Driver.deleteAllRows", query = "DELETE from Driver")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Delivery address;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Truck> trucks = new ArrayList<>();

    public Driver() {
    }

    public Driver(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Delivery getAddress() {
        return address;
    }

    public void setAddress(Delivery address) {
        this.address = address;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setHobby(Truck truck) {
        this.trucks.add(truck);
        truck.setDriver(this);
    }

    @Override
    public String toString() {
        return "Driver{" + "id=" + id + ", name=" + name + ", address=" + address + ", trucks=" + trucks + '}';
    }

}
