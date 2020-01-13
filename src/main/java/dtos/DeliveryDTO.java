/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Cargo;
import entities.Delivery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mkhansen
 */
public class DeliveryDTO {

    private List<CargoDTO> cargoList = new ArrayList();
    private LocalDate date;
    private String fromLocation;
    private String destination;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Delivery delivery) {
        this.date = delivery.getDate();

        for (Cargo cargo : delivery.getCargoList()) {
            cargoList.add(new CargoDTO(cargo));
        }
        this.fromLocation = delivery.getFromLocation();
        this.destination = delivery.getDestination();
    }

    public List<CargoDTO> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<CargoDTO> cargoList) {
        this.cargoList = cargoList;
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

    @Override
    public String toString() {
        return "DeliveryDTO{" + "cargo=" + cargoList + ", date=" + date + ", fromLocation=" + fromLocation + ", destination=" + destination + '}';
    }

}
