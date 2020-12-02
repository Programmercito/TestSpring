/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.web.controllers;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.web.controllers.security.BugsyUtils;
import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisNotas;
import bo.digital.test.model.interfaces.services.IDoctoresService;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.interfaces.services.INotasService;
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
public class Notasweb {

    @Autowired
    INotasService modelo;

    @GetMapping("/notas")
    public List<SisNotas> findAll() {
        return modelo.listar();
    }
    @GetMapping("/notasid")
    public SisNotas findAll(@RequestParam Integer id) {
        return modelo.listarId(id);
    }

    @PostMapping("/notas")
    
    public SisNotas add(@RequestBody SisNotas objeto) {
        if ((objeto.getIdNotas() == null)||(objeto.getIdNotas() == 0)) {
            objeto.setFecCre(new Date());
            objeto.setUsuCre(BugsyUtils.getUser());
        } else {
            objeto.setFecMod(new Date());
            objeto.setUsuMod(BugsyUtils.getUser());
        }
        return modelo.save(objeto);
    }

    @DeleteMapping("/notas")
    public Map<String, String> delete(@RequestBody SisNotas objeto) {
        Map<String, String> resul = new HashMap< String, String>();
        modelo.delete(objeto);
        resul.put("resultado", "ok");
        return resul;
    }

}
