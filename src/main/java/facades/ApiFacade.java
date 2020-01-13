/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.DeliveryDTO;
import dtos.TruckDTO;
import dtos.DriverDTO;
import entities.Cargo;
import entities.Delivery;
import entities.Truck;
import entities.Driver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * @author Mkhansen
 */
public class ApiFacade {

    private static ApiFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private ApiFacade() {
    }

    public static ApiFacade getApiFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ApiFacade();
        }
        return instance;
    }

    public List<DriverDTO> getAllDrivers() {
        EntityManager em = emf.createEntityManager();
        List<DriverDTO> listDTO = new ArrayList<>();
        try {
            List<Driver> list = (List<Driver>) em.createQuery("SELECT d FROM Driver d",Driver.class).getResultList();
            for (Driver driver : list) {
                DriverDTO dDTO = new DriverDTO(driver);
                
                List<TruckDTO> trucksDTO = new ArrayList();
                List<Truck> trucks = driver.getTrucks();
                
                for (Truck truck : trucks) {
                    trucksDTO.add(new TruckDTO(truck));
                }
                dDTO.setTrucks(trucksDTO);
                listDTO.add(dDTO);
            }
            return listDTO;
        } finally {
            em.close();
        }
    }

    public List<TruckDTO> getAllTrucks() {
        EntityManager em = emf.createEntityManager();
        List<TruckDTO> listDTO = new ArrayList<>();
        try {
            List<Truck> list = em.createQuery("SELECT t FROM Truck t").getResultList();
            for (Truck truck : list) {
                listDTO.add(new TruckDTO(truck));
            }
            return listDTO;
        } finally {
            em.close();
        }
    }

    public List<DeliveryDTO> getAllDeliveries() {
        EntityManager em = emf.createEntityManager();
        List<DeliveryDTO> listDTO = new ArrayList<>();
        try {
            List<Delivery> list = em.createQuery("SELECT d FROM Delivery d", Delivery.class).getResultList();
            for (Delivery delivery : list) {
                listDTO.add(new DeliveryDTO(delivery));
            }
            return listDTO;
        } finally {
            em.close();
        }
    }

//    public List<DeliveryDTO> getDriversAndTrucksByDate() {
//        EntityManager em = emf.createEntityManager();
//        List<DeliveryDTO> listDTO = new ArrayList<>();
//        try {
//            List<Delivery> list = em.createQuery("SELECT d FROM Delivery d", Delivery.class).getResultList();
//            for (Delivery delivery : list) {
//                listDTO.add(new DeliveryDTO(delivery));
//            }
//            return listDTO;
//        } finally {
//            em.close();
//        }
//    }
    
    public List<TruckDTO> getTrucksByDate(LocalDate date) {
        EntityManager em = emf.createEntityManager();
        List<TruckDTO> listDTO = new ArrayList<>();
        try {
            TypedQuery<Truck> query = em.createQuery("SELECT t FROM Truck t JOIN t.deliveries d WHERE d.date = :date", Truck.class);
            List<Truck> list = query.setParameter("date", date).getResultList();

            for (Truck truck : list) {
                listDTO.add(new TruckDTO(truck));
            }
            return listDTO;
        } finally {
            em.close();
        }
    }

    public TruckDTO createTruck(TruckDTO inTruck) {
        EntityManager em = emf.createEntityManager();
        Truck outTruck = new Truck(inTruck.getName(), inTruck.getCapacity());
        try {
            em.getTransaction().begin();
            em.persist(outTruck);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new TruckDTO(outTruck);
    }

    public String removeTruck(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Truck> query = em.createQuery(
                    "SELECT t FROM Truck t WHERE t.name = :name", Truck.class);
            Truck truck = query.setParameter("name", name).getSingleResult();

            Truck truckToRemove = em.find(Truck.class, truck.getId());

            em.getTransaction().begin();
            em.remove(truckToRemove);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return "Truck succesfully removed";
    }

    public String removeDriver(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Driver> query = em.createQuery(
                    "SELECT d FROM Driver d WHERE d.name = :name", Driver.class);
            Driver driver = query.setParameter("name", name).getSingleResult();

            Driver driverToRemove = em.find(Driver.class, driver.getId());

            em.getTransaction().begin();
            em.remove(driverToRemove);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return "Truck succesfully removed";
    }

    public TruckDTO editTruck(TruckDTO inTruck) {
        EntityManager em = emf.createEntityManager();

        Truck outTruck = new Truck(inTruck.getName(), inTruck.getCapacity());
        try {
            em.getTransaction().begin();
            em.merge(outTruck);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return new TruckDTO(outTruck);
    }

    public DriverDTO editDriver(DriverDTO inDriver) {
        EntityManager em = emf.createEntityManager();

        Driver outDriver = new Driver(inDriver.getFirstName(), inDriver.getLastName());
        try {
            em.getTransaction().begin();
            em.merge(outDriver);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return new DriverDTO(outDriver);
    }

    public String fillUp() {
        EntityManager em = emf.createEntityManager();
        Driver d1, d2, d3, d4, d5, d6, d7, d8, d9;
        Truck t1, t2, t3, t4, t5, t6, t7, t8;
        Delivery deli1, deli2, deli3, deli4, deli5, deli6, deli7, deli8;
        Cargo c1, c2, c3, c4, c5, c6, c7, c8, c9;

        t1 = new Truck("SuperTruck", "2000");
        t2 = new Truck("The Truck", "400");
        t3 = new Truck("Das Truck", "300");
        t4 = new Truck("Truuuuck", "250");
        t5 = new Truck("TonnyTruck", "1600");
        t6 = new Truck("MediumTruck", "800");
        t7 = new Truck("SmallTruck", "700");
        t8 = new Truck("BigTruck", "1200");

        deli1 = new Delivery("BalladeStræde", "Balladerup");
        deli2 = new Delivery("Herlevhovedgade", "Herlev");
        deli3 = new Delivery("BageStræde", "Albertslun");
        deli4 = new Delivery("Tivoligade", "København");
        deli5 = new Delivery("Århusvej", "Århus");
        deli6 = new Delivery("Herninggade", "Herning");
        deli7 = new Delivery("Roskildevej", "Roskilde");
        deli8 = new Delivery("Hvidovrevej", "Hvidovre");

        c1 = new Cargo("type1", "2345", 200, deli1);
        c2 = new Cargo("type2", "2642", 453, deli2);
        c3 = new Cargo("type3", "23452", 644, deli3);
        c4 = new Cargo("type4", "3164", 2340, deli4);
        c5 = new Cargo("type5", "4264", 643, deli5);
        c6 = new Cargo("type6", "2654", 234, deli6);
        c7 = new Cargo("type7", "7524", 7543, deli7);
        c8 = new Cargo("type8", "24577", 3457, deli8);

        d1 = new Driver("Gurli", "Gris");
        d2 = new Driver("Gunnar", "Gunnarson");
        d3 = new Driver("Peter", "Petersen");
        d4 = new Driver("Polle", "Pollesen");
        d5 = new Driver("Karin", "Karinsen");
        d6 = new Driver("Morten", "Mortensen");
        d7 = new Driver("John", "Johnson");
        d8 = new Driver("Jonna", "Jonnasen");
        d9 = new Driver("Bjørn", "Bjørnsen");

        t1.setDriver(d9);
        t1.setDriver(d2);
        t2.setDriver(d1);
        t2.setDriver(d3);
        t3.setDriver(d4);
        t3.setDriver(d5);
        t4.setDriver(d6);
        t4.setDriver(d7);
        t5.setDriver(d8);
        t5.setDriver(d1);
        t6.setDriver(d2);
        t6.setDriver(d4);
        t7.setDriver(d8);
        t7.setDriver(d7);
        t8.setDriver(d9);
        t8.setDriver(d6);

        deli1.setTruck(t1);
        deli2.setTruck(t2);
        deli3.setTruck(t3);
        deli4.setTruck(t4);
        deli5.setTruck(t5);
        deli6.setTruck(t6);
        deli7.setTruck(t7);
        deli8.setTruck(t8);

        try {

            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.persist(c5);
            em.persist(c6);
            em.persist(c7);
            em.persist(c8);
//            em.persist(deli1);
//            em.persist(deli2);
//            em.persist(deli3);
//            em.persist(deli4);
//            em.persist(deli5);
//            em.persist(deli6);
//            em.persist(deli7);
//            em.persist(deli8);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return "{\"status\":\"filled\"}";
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        ApiFacade pf = ApiFacade.getApiFacade(emf);
//        pf.fillUp();
//        pf.removeTruck("SuperTruck");
//        pf.removeDriver("Peter");
    }
}
