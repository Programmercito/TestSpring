package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisPaciente;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.interfaces.services.IPacienteService;
import bo.digital.test.model.nterfaces.cruds.IHospitales;
import bo.digital.test.model.nterfaces.cruds.IPacientes;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IPacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacientes data;

    @Override
    public List<SisPaciente> listar() {
        return (List<SisPaciente>) data.findAll();
    }

    @Override
    public SisPaciente listarId(Integer id) {
        Optional<SisPaciente> dato = data.findById(id);
        return dato.get();
    }

    @Override
    public SisPaciente save(SisPaciente objeto) {
        return (SisPaciente) data.save(objeto);
    }

    @Override
    public void delete(SisPaciente objeto) {
        data.deleteById(objeto.getIdPaciente());
    }

    @Override
    public List<SisPaciente> buscaPacientes(Date fecha, String nombre, String apellido, int pagina) {
        if (pagina == 0) {
            return data.buscaPacientes(fecha, nombre, apellido);
        } else {
            int noOfRecords = 6;
            Pageable page = PageRequest.of(pagina, noOfRecords, Sort.by("apellido"));
            Page<SisPaciente> pagedResult = data.buscaPacientes(fecha, nombre, apellido, page);
            return pagedResult.getContent();
        }
    }

  

}
