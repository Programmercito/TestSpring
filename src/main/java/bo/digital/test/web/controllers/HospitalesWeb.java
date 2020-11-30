/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.web.controllers;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hered
 */
@RestController

@RequestMapping(path = "/bugsy")
public class HospitalesWeb {

    @Autowired
    IHospitalesService hospitales;

    @GetMapping("/hospitales")
    public List<SisHospitales> findAll() {
        return hospitales.listar();
    }

}
