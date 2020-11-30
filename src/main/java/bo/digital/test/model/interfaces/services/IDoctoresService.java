package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisDoctores;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hered
 */
public interface IDoctoresService {

    public List<SisDoctores> listar();

    public SisDoctores listarId(Integer id);

    public SisDoctores save(SisDoctores objeto);

    public void delete(SisDoctores objeto);

    public List<SisDoctores> buscaDoctores(Date nacimineto, String nombre, String apellido, int pagina);

}
