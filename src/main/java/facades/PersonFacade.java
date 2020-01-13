///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import dtos.TruckDTO;
//import dtos.DriverDTO;
//import entities.Delivery;
//import entities.Truck;
//import entities.Driver;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.TypedQuery;
//import utils.EMF_Creator;
//
///**
// *
// * @author Mkhansen
// */
//public class PersonFacade {
//
//    private static PersonFacade instance;
//    private static EntityManagerFactory emf;
//
//    //Private Constructor to ensure Singleton
//    private PersonFacade() {
//    }
//
//    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new PersonFacade();
//        }
//        return instance;
//    }
//
//    public List<DriverDTO> getAllPersons() {
//        EntityManager em = emf.createEntityManager();
//        List<DriverDTO> listDTO = new ArrayList<>();
//        try {
//            List<Driver> list = em.createQuery("SELECT p FROM Person p").getResultList();
//            for (Driver person : list) {
//                listDTO.add(new DriverDTO(person));
//            }
//            return listDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<TruckDTO> getAllHobbies() {
//        EntityManager em = emf.createEntityManager();
//        List<TruckDTO> listDTO = new ArrayList<>();
//        try {
//            List<Truck> list = em.createQuery("SELECT h FROM Hobby h", Truck.class).getResultList();
//            for (Truck hobby : list) {
//                listDTO.add(new TruckDTO(hobby));
//            }
//            return listDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public DriverDTO getPersonById(int id) {
//        EntityManager em = emf.createEntityManager();
//        DriverDTO pDTO;
//        try {
//            TypedQuery<Driver> query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h JOIN p.address a WHERE p.id = :id", Driver.class);
//            Driver person = query.setParameter("id", id).getSingleResult();
//            pDTO = new DriverDTO(person);
//
//            return pDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public DriverDTO getPersonByEmail(String email) {
//        EntityManager em = emf.createEntityManager();
//        DriverDTO pDTO;
//        try {
//            TypedQuery<Driver> query = em.createQuery("SELECT p FROM Person p WHERE p.email = :email", Driver.class);
//            Driver person = query.setParameter("email", email).getSingleResult();
//            pDTO = new DriverDTO(person);
//
//            return pDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public DriverDTO getPersonByPhone(String phonenumber) {
//        EntityManager em = emf.createEntityManager();
//        DriverDTO pDTO;
//        try {
//            TypedQuery<Driver> query = em.createQuery("SELECT p FROM Person p WHERE p.phone = :phoneNumber", Driver.class);
//            Driver person = query.setParameter("phoneNumber", phonenumber).getSingleResult();
//            pDTO = new DriverDTO(person);
//
//            return pDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<DriverDTO> getAllPersonsByHobby(String name) {
//        EntityManager em = emf.createEntityManager();
//        List<DriverDTO> listDTO = new ArrayList<>();
//        try {
//            TypedQuery<Driver> query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h JOIN p.address a WHERE h.name = :hobbyName", Driver.class);
//
//            List<Driver> list = query.setParameter("hobbyName", name).getResultList();
//
//            for (Driver person : list) {
//                listDTO.add(new DriverDTO(person));
//            }
//
//            return listDTO;
//        } finally {
//            em.close();
//        }
//    }
//
//    public DriverDTO deletePerson(int id) {
//        EntityManager em = emf.createEntityManager();
//        Driver person = em.find(Driver.class, id);
//
//        try {
//            em.getTransaction().begin();
//
//            long count = (long) em.createQuery("SELECT COUNT(r) FROM Person p JOIN p.address a WHERE a.id = :id").setParameter("id", person.getAddress().getId()).getSingleResult();
//
//            if (count == 1) {
//                em.remove(em.find(Delivery.class, person.getAddress().getId()));
//            }
//
//            em.remove(person);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return new DriverDTO(person);
//    }
//
//    public DriverDTO createDriver(DriverDTO person) {
//        EntityManager em = emf.createEntityManager();
//        Driver p = new Driver(person.getName(), person.getlName(), person.getPhone(), person.getEmail());
//
//        Delivery address = new Delivery(person.getAddress().getStreet(), person.getAddress().getCity(), person.getAddress().getZip());
//        p.setAddress(address);
//
//        for (TruckDTO h : person.getTrucks()) {
//            Truck hobby = new Truck();
//
//            try {
//                hobby = em.createQuery("select h from Hobby h where h.name = :name", Truck.class).setParameter("name", h.getName()).getSingleResult();
//            } catch (Exception e) {
//                hobby.setName(h.getName());
//                hobby.setCapacity(h.getCapacity());
//            }
//
//            p.setHobby(hobby);
//        }
//
//        try {
//            em.getTransaction().begin();
//            em.persist(p);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return new DriverDTO(p);
//    }
//
//    public DriverDTO editPerson(int id, DriverDTO pDTO) {
//        EntityManager em = emf.createEntityManager();
//        Driver person = em.find(Driver.class, id);
//        person.setName(pDTO.getName());
//        person.setLastName(pDTO.getlName());
//        person.setPhone(pDTO.getPhone());
//        person.setEmail(pDTO.getEmail());
//
//        Delivery address = new Delivery(pDTO.getAddress().getStreet(), pDTO.getAddress().getCity(), pDTO.getAddress().getZip());
//        person.setAddress(address);
//
//        for (TruckDTO h : pDTO.getTrucks()) {
//            Truck hobby = new Truck(h.getName(), h.getCapacity());
//            person.setHobby(hobby);
//        }
//
//        try {
//            em.getTransaction().begin();
//            em.merge(person);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return pDTO;
//    }
//
//    public TruckDTO createHobby(TruckDTO h) {
//        EntityManager em = emf.createEntityManager();
//        Truck hobby = new Truck(h.getName(), h.getCapacity());
//        try {
//            em.getTransaction().begin();
//            em.persist(hobby);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return new TruckDTO(hobby);
//    }
//
//    public TruckDTO removeHobby(String name) {
//        EntityManager em = emf.createEntityManager();
//        Truck hobby = em.find(Truck.class, name);
//        try {
//            em.getTransaction().begin();
//            em.remove(hobby);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return new TruckDTO(hobby);
//    }
//
//    public TruckDTO editHobby(TruckDTO h) {
//        EntityManager em = emf.createEntityManager();
//
//        Truck hobby = new Truck(h.getName(), h.getCapacity());
//        try {
//            em.getTransaction().begin();
//            em.merge(hobby);
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//        return new TruckDTO(hobby);
//    }
//
//    public String fillUp() {
//        EntityManager em = emf.createEntityManager();
//        Driver p1;
//        Person p2, p3, p4, p5, p6, p7, p8, p9;
//        Truck hobby1; 
//        Hobby hobby2, hobby3, hobby4, hobby5, hobby6, hobby7, hobby8, hobby9; 
//        Delivery address1;
//        Address address2, address3, address4, address5, address6, address7, address8, address9;
//
//        hobby1 = new Truck("Cykling", "Cykling på hold");
//        hobby2 = new Truck("Fodbold", "Spark til bold");
//        hobby3 = new Truck("Håndbold", "Kast med bold");
//        hobby4 = new Truck("Ski", "Noget med sne");
//        hobby5 = new Truck("Snowboard", "Stå på et bræt");
//        hobby6 = new Truck("Mountainbike", "Cykling i skoven");
//        hobby7 = new Truck("Rollespil", "Noget med papsværd");
//        hobby8 = new Truck("Gocart", "4 hjul og 1 motor");
//
//        address1 = new Delivery("BalladeStræde", "Balladerup", "2750");
//        address2 = new Delivery("Herlevhovedgade", "Herlev", "1234");
//        address3 = new Delivery("BageStræde", "Albertslun", "2647");
//        address4 = new Delivery("Tivoligade", "København", "4574");
//        address5 = new Delivery("Århusvej", "Århus", "8356");
//        address6 = new Delivery("Herninggade", "Herning", "9764");
//        address7 = new Delivery("Roskildevej", "Roskilde", "9674");
//        address8 = new Delivery("Hvidovrevej", "Hvidovre", "4584");
//        address9 = new Delivery("Skovlundevej", "Skovlunde", "3585");
//        
//        p1 = new Driver("Gurli", "Mogensen", "44556677", "email@email.com");
//        p2 = new Driver("Gunnar", "Hjorth", "11223344", "mail@email.com");
//        p3 = new Driver("Peter", "Petersen", "22337755", "1234@email.com");
//        p4 = new Driver("Pernille", "Pernillesen", "12345678", "todo@email.com");
//        p5 = new Driver("Karin", "Karinsen", "88774422", "what@eemail.com");
//        p6 = new Driver("Morten", "Mortensen", "44227755", "ever@email.com");
//        p7 = new Driver("John", "Johnsen", "99664422", "john@eemail.com");
//        p8 = new Driver("Jonna", "jonse", "11447788", "yoyo@email.com");
//        p9 = new Driver("Bjørn", "Jernside", "66449922", "anotherEmail@eemail.com");
//        
//        p1.setHobby(hobby1);
//        p1.setHobby(hobby3);
//        p1.setHobby(hobby5);
//        
//        p2.setHobby(hobby2);
//        p2.setHobby(hobby4);
//        p2.setHobby(hobby6);
//        
//        p3.setHobby(hobby3);
//        p3.setHobby(hobby5);
//        p3.setHobby(hobby7);
//        
//        p4.setHobby(hobby4);
//        p4.setHobby(hobby6);
//        p4.setHobby(hobby8);
//        
//        p5.setHobby(hobby1);
//        p5.setHobby(hobby3);
//        p5.setHobby(hobby5);
//        
//        p6.setHobby(hobby2);
//        p6.setHobby(hobby4);
//        p6.setHobby(hobby6);
//        
//        p7.setHobby(hobby3);
//        p7.setHobby(hobby5);
//        p7.setHobby(hobby7);
//        
//        p8.setHobby(hobby4);
//        p8.setHobby(hobby6);
//        p8.setHobby(hobby8);
//
//        p9.setHobby(hobby4);
//        p9.setHobby(hobby6);
//        p9.setHobby(hobby8);
//       
//        p1.setAddress(address1);
//        p2.setAddress(address2);
//        p3.setAddress(address3);
//        p4.setAddress(address4);
//        p5.setAddress(address5);
//        p6.setAddress(address6);
//        p7.setAddress(address7);
//        p8.setAddress(address8);
//        p9.setAddress(address9);
//        
//        try {
//
//            em.getTransaction().begin();
//            em.persist(p1);
//            em.persist(p2);
//            em.persist(p3);
//            em.persist(p4);
//            em.persist(p5);
//            em.persist(p6);
//            em.persist(p7);
//            em.persist(p8);
//            em.persist(p9);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return "{\"status\":\"filled\"}";
//    }
//    
////        public static void main(String[] args) {
////        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
////        PersonFacade pf = PersonFacade.getPersonFacade(emf);
////        pf.fillUp();
//////            System.out.println(pf.getPersonByEmail("email@email.com"));
//////            System.out.println(pf.getPersonByPhone("11223344"));
////    }
//}
