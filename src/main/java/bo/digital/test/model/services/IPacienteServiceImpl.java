package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisPaciente;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.interfaces.services.IPacienteService;
import bo.digital.test.model.nterfaces.cruds.IHospitales;
import bo.digital.test.model.nterfaces.cruds.IPacientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
        data.delete(objeto);
    }

}
