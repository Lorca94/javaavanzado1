package com.openbootcamp.demoSpringRest.Controller;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import com.openbootcamp.demoSpringRest.service.BootcamperService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcamperController {
    private final BootcamperService bootcamperService;

    public BootcamperController(BootcamperService bootcamperService) {

        this.bootcamperService = bootcamperService;
        this.bootcamperService.add(new Bootcamper("uno", Math.random()));
        this.bootcamperService.add(new Bootcamper("dos", Math.random()));
        this.bootcamperService.add(new Bootcamper("tres", Math.random()));
        this.bootcamperService.add(new Bootcamper("cuatro", Math.random()));
        this.bootcamperService.add(new Bootcamper("cinco", Math.random()));
        this.bootcamperService.add(new Bootcamper("seis", Math.random()));
    }

    @GET
    @Path("/bootcamp")
    @Produces("application/json")
    public List<Bootcamper> findAll() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcamp/{nombre}")
    @Produces("application/json")
    public Bootcamper findByName(@PathParam("nombre") String nombre) {
        return bootcamperService.get(nombre);

    }
    @POST
    @Path("/bootcamp")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcamp/" + bootcamper.getNombre())
        ).build();
    }
}

