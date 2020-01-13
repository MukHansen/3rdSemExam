/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DeliveryDTO;
import dtos.DriverDTO;
import dtos.TruckDTO;
import entities.Delivery;
import entities.Driver;
import facades.ApiFacade;
import facades.FacadeExample;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author Mkhansen
 */
@Path("exam")
public class ExamResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/3rdSemExam",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final ApiFacade FACADE = ApiFacade.getApiFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

//    @GET
//    @Path("id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonDTO getPersonByID(@PathParam("id") int id) {
//        return FACADE.getPersonById(id);
//    }
//
//    @GET
//    @Path("phone/{phoneNumber}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonDTO getPersonByPhone(@PathParam("phoneNumber") String phoneNumber) {
//        return FACADE.getPersonByPhone(phoneNumber);
//    }
//
//    @GET
//    @Path("email/{email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonDTO getPersonByEmail(@PathParam("email") String email) {
//        return FACADE.getPersonByEmail(email);
//    }
//
//    @GET
//    @Path("hobby/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<PersonDTO> getAllPersonByHobby(@PathParam("name") String name) {
//        return FACADE.getAllPersonsByHobby(name);
//    }
//
//    @GET
//    @Path("allhobbies")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<TruckDTO> getAllHobbies() {
//        return FACADE.getAllHobbies();
//    }
//
//    @POST
//    @Path("createperson")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public PersonDTO createPerson(PersonDTO pDTO) {
//        return FACADE.createDriver(pDTO);
//    }
//
//    @DELETE
//    @Path("/deleteperson/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public PersonDTO deletePerson(@PathParam("id") int id) {
//        return FACADE.deletePerson(id);
//    }
//
//    @PUT
//    @Path("/editperson/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public PersonDTO editPerson(@PathParam("id") int id, PersonDTO pDTO) {
//        return FACADE.editPerson(id, pDTO);
//    }
//    @POST
//    @Path("createTruck")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public TruckDTO createTruck(TruckDTO tDTO) {
//        return FACADE.createTruck(tDTO);
//    }
    @GET
    @Path("alltrucks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TruckDTO> getAllTrucks() {
        return FACADE.getAllTrucks();
    }

    @GET
    @Path("alldrivers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DriverDTO> getAllDrivers() {
        return FACADE.getAllDrivers();
    }

    @GET
    @Path("alldeliveries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeliveryDTO> getAllDeliveries() {
        return FACADE.getAllDeliveries();
    }

    @DELETE
    @Path("/deletetruck/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteTruck(@PathParam("name") long id) {
        return FACADE.removeTruck(id);
    }

    @DELETE
    @Path("/deletedriver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteDriver(@PathParam("name") long id) {
        return FACADE.removeDriver(id);
    }

    @DELETE
    @Path("/deletedelivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteDelivery(@PathParam("name") long id) {
        return FACADE.removeDriver(id);
    }

    @PUT
    @Path("/edittruck")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TruckDTO editTruck(TruckDTO tDTO) {
        return FACADE.editTruck(tDTO);
    }

//    @POST
//    @Path("createdriver")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public DriverDTO createTruck(DriverDTO dDTO) {
//        return FACADE.createDriver(dDTO);
//    }

    @PUT
    @Path("/editdriver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DriverDTO editDriver(DriverDTO dDTO) {
        return FACADE.editDriver(dDTO);
    }

    @GET
    @Path("fill")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFilling() {
        return FACADE.fillUp();
    }
}
