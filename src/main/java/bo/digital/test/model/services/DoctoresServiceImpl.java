package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.model.entities.SisPaciente;
import bo.digital.test.model.interfaces.services.IDoctoresService;
import bo.digital.test.model.nterfaces.cruds.IDoctores;
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
public class DoctoresServiceImpl implements IDoctoresService {

    @Autowired
    private IDoctores data;

    @Override
    public List<SisDoctores> listar() {
        return (List<SisDoctores>) data.findAll();
    }

    @Override
    public SisDoctores listarId(Integer id) {
        Optional<SisDoctores> dato = data.findById(id);
        return dato.get();
    }

    @Override
    public SisDoctores save(SisDoctores objeto) {
        return (SisDoctores) data.save(objeto);
    }

    @Override
    public void delete(SisDoctores objeto) {
        data.delete(objeto);
    }

    @Override
    public List<SisDoctores> buscaDoctores(Date fecha, String nombre, String apellido, int pagina) {
        if (pagina == 0) {
            return data.buscaDoctores(fecha, nombre, apellido);
        } else {
            int noOfRecords = 6;
            Pageable page = PageRequest.of(pagina, noOfRecords, Sort.by("apellido"));
            Page<SisDoctores> pagedResult = data.buscaDoctores(fecha, nombre, apellido, page);
            return pagedResult.getContent();
        }
    }


}
