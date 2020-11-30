package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisHospitales;
import java.util.List;

/**
 *
 * @author hered
 */
public interface IHospitalesService {

    public List<SisHospitales> listar();

    public SisHospitales listarId(Integer id);

    public SisHospitales save(SisHospitales objeto);

    public void delete(SisHospitales objeto);
}
