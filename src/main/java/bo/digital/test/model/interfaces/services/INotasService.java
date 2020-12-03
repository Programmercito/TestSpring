package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisNotas;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hered
 */
public interface INotasService {

    public List<SisNotas> listar();

    public SisNotas listarId(Integer id);

    public SisNotas save(SisNotas objeto);

    public void delete(SisNotas objeto);
    
    public List<SisNotas> listarbyPaciente(@Param("paciente") Integer paciente);
}
