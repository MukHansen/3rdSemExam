/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Cargo;
import entities.Delivery;

/**
 *
 * @author Mkhansen;
 */
public class CargoDTO {
    
    private String name;
    private String weight;
    private int units;
    private Delivery delivery;

    public CargoDTO() {
    }
    
    CargoDTO(Cargo cargo) {
        this.name = cargo.getName();
        this.weight = cargo.getWeight();
        this.units = cargo.getUnits();
        this.delivery = cargo.getDelivery();
    }
    
    public CargoDTO(String name, String weight, int units, Delivery delivery) {
        this.name = name;
        this.weight = weight;
        this.units = units;
        this.delivery = delivery;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "CargoDTO{" + "name=" + name + ", weight=" + weight + ", units=" + units + ", delivery=" + delivery + '}';
    }
    
}
