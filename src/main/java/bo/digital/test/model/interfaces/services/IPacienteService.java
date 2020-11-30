package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisPaciente;
import java.util.List;

/**
 *
 * @author hered
 */
public interface IPacienteService {

    public List<SisPaciente> listar();

    public SisPaciente listarId(Integer id);

    public SisPaciente save(SisPaciente objeto);

    public void delete(SisPaciente objeto);
}
