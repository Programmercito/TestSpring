/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.web.controllers;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.web.controllers.security.BugsyUtils;
import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hered
 */
@RestController

@RequestMapping(path = "/bugsy")
public class HospitalesWeb {

    @Autowired
    IHospitalesService modelo;

    @GetMapping("/hospitales")
    public List<SisHospitales> findAll() {
        return modelo.listar();
    }

    @GetMapping("/hospitalesid")
    public SisHospitales findAll(@RequestParam Integer id) {
        return modelo.listarId(id);
    }

    @PostMapping("/hospitales")

    public SisHospitales add(@RequestBody SisHospitales hospital) {
        if (hospital.getIdHospitales() == null) {
            hospital.setFecCre(new Date());
            hospital.setUsuCre(BugsyUtils.getUser());
        } else {
            hospital.setFecMod(new Date());
            hospital.setUsuMod(BugsyUtils.getUser());
        }
        return modelo.save(hospital);
    }

    @DeleteMapping("/hospitales")
    public Map<String, String> delete(@RequestBody SisHospitales hospital) {
        Map<String, String> resul = new HashMap< String, String>();
        modelo.delete(hospital);
        resul.put("resultado", "ok");
        return resul;
    }

}
