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

    @DELETE
    @Path("/deletetruck/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteTruck(@PathParam("id") long id) {
        return FACADE.removeTruck(id);
    }

    @DELETE
    @Path("/deletedriver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteDriver(@PathParam("id") long id) {
        return FACADE.removeDriver(id);
    }

    @DELETE
    @Path("/deletedelivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteDelivery(@PathParam("id") long id) {
        return FACADE.removeDriver(id);
    }

    @PUT
    @Path("/edittruck")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TruckDTO editTruck(TruckDTO tDTO) {
        return FACADE.editTruck(tDTO);
    }

    @POST
    @Path("createdriver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DriverDTO createTruck(DriverDTO dDTO) {
        return FACADE.createDriver(dDTO);
    }

    @PUT
    @Path("/editdriver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DriverDTO editDriver(@PathParam("id") long id, DriverDTO dDTO) {
        return FACADE.editDriver(id, dDTO);
    }

    @GET
    @Path("fill")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFilling() {
        return FACADE.fillUp();
    }
}
