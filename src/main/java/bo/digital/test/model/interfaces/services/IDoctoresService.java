package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisDoctores;
import java.util.List;

/**
 *
 * @author hered
 */
public interface IDoctoresService {

    public List<SisDoctores> listar();

    public SisDoctores listarId(Integer id);

    public SisDoctores save(SisDoctores objeto);

    public void delete(SisDoctores objeto);
}
