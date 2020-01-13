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
    private Long id;
    private String firstName;
    private String lastName;
    
    @ManyToMany(mappedBy = "drivers", cascade = CascadeType.PERSIST)
    private List<Truck> trucks = new ArrayList<>();

    public Driver() {
    }

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Driver{" + "id=" + id + ", name=" + firstName + ", trucks=" + trucks + '}';
    }

}
