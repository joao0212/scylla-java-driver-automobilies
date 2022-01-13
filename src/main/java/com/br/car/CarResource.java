package com.br.car;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarDAO carDAO;

    @GET
    public List<Car> findAll() {
        return carDAO.findAll();
    }

    @POST
    public void save(Car car) {
        carDAO.save(car);
    }
}
