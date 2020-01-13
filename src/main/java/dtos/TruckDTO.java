/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Delivery;
import entities.Driver;
import entities.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mkhansen
 */
public class TruckDTO {

    private String name;
    private String capacity;
    private List<DriverDTO> drivers = new ArrayList<>();
    private List<DeliveryDTO> deliveries = new ArrayList<>();

    public TruckDTO() {
    }

    public TruckDTO(Truck truck) {
        this.name = truck.getName();
        this.capacity = truck.getCapacity();

//        for (Driver driver : truck.getDrivers()) {
//            drivers.add(new DriverDTO(driver));
//        }
//        for (Delivery delivery : truck.getDeliveries()) {
//            deliveries.add(new DeliveryDTO(delivery));
//        }
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

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public void addDrivers(DriverDTO driver) {
        this.drivers.add(driver);
    }

    public List<DeliveryDTO> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliveryDTO> deliveries) {
        this.deliveries = deliveries;
    }

    public void addDelivery(DeliveryDTO delivery) {
        this.deliveries.add(delivery);
    }

    @Override
    public String toString() {
        return "TruckDTO{" + "name=" + name + ", capacity=" + capacity + ", drivers=" + drivers + ", deliveries=" + deliveries + '}';
    }

}
