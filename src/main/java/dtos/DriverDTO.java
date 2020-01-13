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

    private String name;
    private List<TruckDTO> trucks = new ArrayList<>();

    public DriverDTO() {
    }

    public DriverDTO(Driver driver) {
        this.name = driver.getName();

        for (Truck truck : driver.getTrucks()) {
            trucks.add(new TruckDTO(truck));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
