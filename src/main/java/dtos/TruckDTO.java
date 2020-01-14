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
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.capacity);
        hash = 59 * hash + Objects.hashCode(this.drivers);
        hash = 59 * hash + Objects.hashCode(this.deliveries);
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
        final TruckDTO other = (TruckDTO) obj;
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
