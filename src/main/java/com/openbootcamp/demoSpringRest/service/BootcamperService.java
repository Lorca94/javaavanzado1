package com.openbootcamp.demoSpringRest.service;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcamperService {

    private final List<Bootcamper> bootcampers = new ArrayList<>();

    public List<Bootcamper> getAll() {
        return bootcampers;
    }

    public void add(Bootcamper bootcamper) { bootcampers.add(bootcamper); }

    public Bootcamper get(String nombre) {
        for(Bootcamper bootcamper : bootcampers){
            if(bootcamper.getNombre().equals(nombre)){
                return bootcamper;
            }
        }
        return null;
    }
}
