package bo.digital.test.model.interfaces.services;

import bo.digital.test.model.entities.SisEspecialidades;
import java.util.List;

/**
 *
 * @author hered
 */
public interface IEspecialidadesService {

    public List<SisEspecialidades> listar();

    public SisEspecialidades listarId(Integer id);

    public SisEspecialidades save(SisEspecialidades objeto);

    public void delete(SisEspecialidades objeto);
}
