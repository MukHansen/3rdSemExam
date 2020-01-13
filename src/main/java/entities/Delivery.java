/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Mkhansen
 */
@Entity
@NamedQuery(name = "Delivery.deleteAllRows", query = "DELETE from Delivery")
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String fromLocation;
    private String destination;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Truck truck;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.PERSIST)
    private List<Cargo> cargoList = new ArrayList<>();

    public Delivery() {
    }

    public Delivery(String fromLocation, String destination) {
        this.date = date.now();
        this.fromLocation = fromLocation;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargo(Cargo cargo) {
        this.cargoList.add(cargo);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Truck getTrucks() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

}
