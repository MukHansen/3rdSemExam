///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import dtos.DeliveryDTO;
//import dtos.DriverDTO;
//import dtos.TruckDTO;
//import entities.Cargo;
//import entities.Delivery;
//import entities.Driver;
//import entities.Truck;
//import java.time.LocalDate;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.EMF_Creator;
//
///**
// *
// * @author Mkhansen;
// */
//public class ApiFacadeTest {
//
//    private static EntityManagerFactory emf;
//    private static ApiFacade facade;
//    private EntityManager em;
//
//    private Driver d1, d2, d3, d4, d5, d6, d7, d8, d9;
//    private Truck t1, t2, t3, t4, t5, t6, t7, t8;
//    private Delivery deli1, deli2, deli3, deli4, deli5, deli6, deli7, deli8;
//    private Cargo c1, c2, c3, c4, c5, c6, c7, c8, c9;
//
//    @AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @BeforeEach
//    public void setUp() throws Exception {
//
//        t1 = new Truck("SuperTruck", "2000");
//        t2 = new Truck("The Truck", "400");
//        t3 = new Truck("Das Truck", "300");
//        t4 = new Truck("Truuuuck", "250");
//        t5 = new Truck("TonnyTruck", "1600");
//        t6 = new Truck("MediumTruck", "800");
//        t7 = new Truck("SmallTruck", "700");
//        t8 = new Truck("BigTruck", "1200");
//
//        deli1 = new Delivery("BalladeStræde", "Balladerup");
//        deli2 = new Delivery("Herlevhovedgade", "Herlev");
//        deli3 = new Delivery("BageStræde", "Albertslun");
//        deli4 = new Delivery("Tivoligade", "København");
//        deli5 = new Delivery("Århusvej", "Århus");
//        deli6 = new Delivery("Herninggade", "Herning");
//        deli7 = new Delivery("Roskildevej", "Roskilde");
//        deli8 = new Delivery("Hvidovrevej", "Hvidovre");
//
//        c1 = new Cargo("type1", "2345", 200, deli1);
//        c2 = new Cargo("type2", "2642", 453, deli2);
//        c3 = new Cargo("type3", "23452", 644, deli3);
//        c4 = new Cargo("type4", "3164", 2340, deli4);
//        c5 = new Cargo("type5", "4264", 643, deli5);
//        c6 = new Cargo("type6", "2654", 234, deli6);
//        c7 = new Cargo("type7", "7524", 7543, deli7);
//        c8 = new Cargo("type8", "24577", 3457, deli8);
//
//        d1 = new Driver("Gurli", "Gris");
//        d2 = new Driver("Gunnar", "Gunnarson");
//        d3 = new Driver("Peter", "Petersen");
//        d4 = new Driver("Polle", "Pollesen");
//        d5 = new Driver("Karin", "Karinsen");
//        d6 = new Driver("Morten", "Mortensen");
//        d7 = new Driver("John", "Johnson");
//        d8 = new Driver("Jonna", "Jonnasen");
//        d9 = new Driver("Bjørn", "Bjørnsen");
//
//        t1.setDriver(d9);
//        t1.setDriver(d2);
//        t2.setDriver(d1);
//        t2.setDriver(d3);
//        t3.setDriver(d4);
//        t3.setDriver(d5);
//        t4.setDriver(d6);
//        t4.setDriver(d7);
//        t5.setDriver(d8);
//        t5.setDriver(d1);
//        t6.setDriver(d2);
//        t6.setDriver(d4);
//        t7.setDriver(d8);
//        t7.setDriver(d7);
//        t8.setDriver(d9);
//        t8.setDriver(d6);
//
//        deli1.setTruck(t1);
//        deli2.setTruck(t2);
//        deli3.setTruck(t3);
//        deli4.setTruck(t4);
//        deli5.setTruck(t5);
//        deli6.setTruck(t6);
//        deli7.setTruck(t7);
//        deli8.setTruck(t8);
//        
//        em = emf.createEntityManager();
//        try {
//
//            em.getTransaction().begin();
//            em.persist(c1);
//            em.persist(c2);
//            em.persist(c3);
//            em.persist(c4);
//            em.persist(c5);
//            em.persist(c6);
//            em.persist(c7);
//            em.persist(c8);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Cargo.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Delivery.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Truck.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Driver.deleteAllRows").executeUpdate();
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @BeforeAll
//    public static void setUpClass() throws Exception {
//        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
//        facade = ApiFacade.getApiFacade(emf);
//    }
//
//    /**
//     * Test of getAllDrivers method, of class ApiFacade.
//     */
////    @Test
////    public void testGetAllDrivers() {
////        System.out.println("getAllDrivers");
////        ApiFacade instance = null;
////        List<DriverDTO> expResult = null;
////        List<DriverDTO> result = instance.getAllDrivers();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    /**
//     * Test of removeDriver method, of class ApiFacade.
//     */
////    @Test
////    public void testRemoveDriver() {
////        System.out.println("removeDriver");
////        long id = 0L;
////        ApiFacade instance = null;
////        String expResult = "";
////        String result = instance.removeDriver(id);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    /**
//     * Test of createDriver method, of class ApiFacade.
//     */
//    @Test
//    public void testCreateDriver() {
//        System.out.println("createDriver");
//        DriverDTO inDriver = new DriverDTO(d1);
//        ApiFacade instance = facade;
//        DriverDTO result = instance.createDriver(inDriver);
//        DriverDTO dDTO = facade.createDriver(inDriver);
//        assertNotNull(dDTO.getId());
//    }
//
//    /**
//     * Test of editDriver method, of class ApiFacade.
//     */
////    @Test
////    public void testEditDriver() {
////        System.out.println("editDriver");
////        Long id = null;
////        DriverDTO inDriverDTO = null;
////        ApiFacade instance = null;
////        DriverDTO expResult = null;
////        DriverDTO result = instance.editDriver(id, inDriverDTO);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//}
