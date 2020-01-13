/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Truck;

/**
 *
 * @author Mkhansen
 */
public class TruckDTO {

    private String name;
    private String capacity;

    public TruckDTO() {
    }

    public TruckDTO(Truck truck) {
        this.name = truck.getName();
        this.capacity = truck.getCapacity();
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

    @Override
    public String toString() {
        return "TruckDTO{" + "name=" + name + ", capacity=" + capacity + '}';
    }

}
