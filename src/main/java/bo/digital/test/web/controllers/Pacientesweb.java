/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.web.controllers;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.web.controllers.security.BugsyUtils;
import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisPaciente;
import bo.digital.test.model.interfaces.services.IDoctoresService;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.interfaces.services.IPacienteService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Pacientesweb {

    @Autowired
    IPacienteService modelo;

    @GetMapping("/pacientes")
    public List<SisPaciente> findAll() {
        return modelo.listar();
    }

    @GetMapping("/pacientesid")
    public SisPaciente findAll(@RequestParam Integer id) {
        return modelo.listarId(id);
    }

    @PostMapping("/pacientes")
    public SisPaciente add(@RequestBody SisPaciente objeto) {
        if (objeto.getIdPaciente() == null) {
            objeto.setFecCre(new Date());
            objeto.setUsuCre(BugsyUtils.getUser());
        } else {
            objeto.setFecMod(new Date());
            objeto.setUsuMod(BugsyUtils.getUser());
        }
        return modelo.save(objeto);
    }

    @DeleteMapping("/pacientes")
    public Map<String, String> delete(@RequestBody SisPaciente objeto) {
        Map<String, String> resul = new HashMap< String, String>();
        SisPaciente paciente=modelo.listarId(objeto.getIdPaciente());
        
        modelo.delete(paciente);
      
        resul.put("resultado", "ok");
        return resul;
    }

    @GetMapping("/pacientessearch")
    public List<SisPaciente> findAllParams(@RequestParam(required = false) String fecha, @RequestParam(required = false) String nombre, @RequestParam(required = false) String apellido, @RequestParam int pagina) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaa = sdf.parse(fecha);
        return modelo.buscaPacientes(fechaa, nombre, apellido, pagina);
    }

}
