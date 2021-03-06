/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Mkhansen
 */
@Entity
@NamedQuery(name = "Truck.deleteAllRows", query = "DELETE from Truck")
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String capacity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Driver> drivers = new ArrayList<>();

    @OneToMany(mappedBy = "truck", cascade = CascadeType.PERSIST)
    private List<Delivery> deliveries = new ArrayList<>();

    public Truck() {
    }

    public Truck(String name, String capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDriver(Driver driver) {
        this.drivers.add(driver);
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setPerson(Delivery delivery) {
        this.deliveries.add(delivery);
    }

    @Override
    public String toString() {
        return "Truck{" + "name=" + name + ", capacity=" + capacity + ", drivers=" + drivers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.capacity);
        hash = 79 * hash + Objects.hashCode(this.drivers);
        hash = 79 * hash + Objects.hashCode(this.deliveries);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Truck other = (Truck) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.capacity, other.capacity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.drivers, other.drivers)) {
            return false;
        }
        if (!Objects.equals(this.deliveries, other.deliveries)) {
            return false;
        }
        return true;
    }
    
}
