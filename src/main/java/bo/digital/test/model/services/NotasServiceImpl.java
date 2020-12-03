package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisNotas;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.interfaces.services.INotasService;
import bo.digital.test.model.nterfaces.cruds.IHospitales;
import bo.digital.test.model.nterfaces.cruds.INotas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NotasServiceImpl implements INotasService {

    @Autowired
    private INotas data;

    @Override
    public List<SisNotas> listar() {
        return (List<SisNotas>) data.findAll();
    }

    @Override
    public SisNotas listarId(Integer id) {
        Optional<SisNotas> dato = data.findById(id);
        return dato.get();
    }

    @Override
    public SisNotas save(SisNotas objeto) {
        return (SisNotas) data.save(objeto);
    }

    @Override
    public void delete(SisNotas objeto) {
        data.deleteById(objeto.getIdNotas());
    }

    @Override
    public List<SisNotas> listarbyPaciente(Integer paciente) {
       return data.listarbyPaciente(paciente);
    }

}
