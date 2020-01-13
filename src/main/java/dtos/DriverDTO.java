/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Driver;
import entities.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mkhansen
 */
public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<TruckDTO> trucks;

    public DriverDTO() {
    }

    public DriverDTO(Driver driver) {
        this.id = driver.getId();
        this.firstName = driver.getFirstName();
        this.lastName = driver.getLastName();
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

    public List<TruckDTO> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<TruckDTO> trucks) {
        this.trucks = trucks;
    }

    public void addTruck(TruckDTO truck) {
        if (trucks == null) {
            trucks = new ArrayList();
        }
        this.trucks.add(truck);
    }

    @Override
    public String toString() {
        return "DriverDTO{" + "name=" + firstName + ", trucks=" + trucks + '}';
    }
}
