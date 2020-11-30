package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.interfaces.services.IHospitalesService;
import bo.digital.test.model.nterfaces.cruds.IHospitales;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class HospitalesServiceImpl implements IHospitalesService {

    @Autowired
    private IHospitales data;

    @Override
    public List<SisHospitales> listar() {
        return (List<SisHospitales>) data.findAll();
    }

    @Override
    public SisHospitales listarId(Integer id) {
        Optional<SisHospitales> dato = data.findById(id);
        return dato.get();
    }

    @Override
    public SisHospitales save(SisHospitales objeto) {
        return (SisHospitales) data.save(objeto);
    }

    @Override
    public void delete(SisHospitales objeto) {
        data.delete(objeto);
    }

}
