/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.web.controllers;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.model.entities.SisEspecialidades;
import bo.digital.test.web.controllers.security.BugsyUtils;
import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.interfaces.services.IDoctoresService;
import bo.digital.test.model.interfaces.services.IEspecialidadesService;
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
public class Especialidadesweb {

    @Autowired
    IEspecialidadesService modelo;

    @GetMapping("/especialidades")
    public List<SisEspecialidades> findAll() {
        return modelo.listar();
    }
    @GetMapping("/especialidadesid")
    public SisEspecialidades findAll(@RequestParam Integer id) {
        return modelo.listarId(id);
    }
    @PostMapping("/especialidades")
    
    public SisEspecialidades add(@RequestBody SisEspecialidades objeto) {
        if (objeto.getIdDoctor() == null) {
            objeto.setFecCre(new Date());
            objeto.setUsuCre(BugsyUtils.getUser());
        } else {
            objeto.setFecMod(new Date());
            objeto.setUsuMod(BugsyUtils.getUser());
        }
        return modelo.save(objeto);
    }

    @DeleteMapping("/especialidades")
    public Map<String, String> delete(SisEspecialidades objeto) {
        Map<String, String> resul = new HashMap< String, String>();
        modelo.delete(objeto);
        resul.put("resultado", "ok");
        return resul;
    }

}
