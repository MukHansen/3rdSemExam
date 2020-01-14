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
import java.util.Objects;

/**
 *
 * @author Mkhansen
 */
public class DeliveryDTO {
    
    private Long id;
    private List<CargoDTO> cargoList;
    private LocalDate date;
    private String fromLocation;
    private String destination;
    private TruckDTO truckDTO;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Delivery delivery) {
        this.date = delivery.getDate();

//        for (Cargo cargo : delivery.getCargoList()) {
//            cargoList.add(new CargoDTO(cargo));
//        }
        this.fromLocation = delivery.getFromLocation();
        this.destination = delivery.getDestination();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CargoDTO> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<CargoDTO> cargoList) {
        this.cargoList = cargoList;
    }

    public void addCargo(CargoDTO cargo) {
        if (cargoList == null) {
            cargoList = new ArrayList();
        }
        this.cargoList.add(cargo);
    }

    public TruckDTO getTruckDTO() {
        return truckDTO;
    }

    public void setTruckDTO(TruckDTO truckDTO) {
        this.truckDTO = truckDTO;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.cargoList);
        hash = 37 * hash + Objects.hashCode(this.date);
        hash = 37 * hash + Objects.hashCode(this.fromLocation);
        hash = 37 * hash + Objects.hashCode(this.destination);
        hash = 37 * hash + Objects.hashCode(this.truckDTO);
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
        final DeliveryDTO other = (DeliveryDTO) obj;
        if (!Objects.equals(this.fromLocation, other.fromLocation)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cargoList, other.cargoList)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.truckDTO, other.truckDTO)) {
            return false;
        }
        return true;
    }

}
