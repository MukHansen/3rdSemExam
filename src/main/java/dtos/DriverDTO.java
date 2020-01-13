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

    private String firstName;
    private String lastName;
    private List<TruckDTO> trucks = new ArrayList<>();

    public DriverDTO() {
    }

    public DriverDTO(Driver driver) {
        this.firstName = driver.getFirstName();
        this.lastName = driver.getLastName();
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
        this.trucks.add(truck);
    }

    @Override
    public String toString() {
        return "DriverDTO{" + "name=" + firstName + ", trucks=" + trucks + '}';
    }
}
