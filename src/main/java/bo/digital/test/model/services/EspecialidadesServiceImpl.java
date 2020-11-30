package bo.digital.test.model.services;

import bo.digital.test.model.entities.SisEspecialidades;
import bo.digital.test.model.interfaces.services.IEspecialidadesService;
import bo.digital.test.model.nterfaces.cruds.IEspecialidades;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class EspecialidadesServiceImpl implements IEspecialidadesService {

    @Autowired
    private IEspecialidades data;

    @Override
    public List<SisEspecialidades> listar() {
        return (List<SisEspecialidades>) data.findAll();
    }

    @Override
    public SisEspecialidades listarId(Integer id) {
        Optional<SisEspecialidades> dato = data.findById(id);
        return dato.get();
    }

    @Override
    public SisEspecialidades save(SisEspecialidades objeto) {
        return (SisEspecialidades) data.save(objeto);
    }

    @Override
    public void delete(SisEspecialidades objeto) {
        data.delete(objeto);
    }

}
