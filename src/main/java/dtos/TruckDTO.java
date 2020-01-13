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

    private Long id;
    private String name;
    private String capacity;
    private List<DriverDTO> drivers;
    private List<DeliveryDTO> deliveries;

    public TruckDTO() {
    }

    public TruckDTO(Truck truck) {
        this.name = truck.getName();
        this.capacity = truck.getCapacity();

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

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public void addDriver(DriverDTO driver) {
        if (drivers == null) {
            drivers = new ArrayList();
        }
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
