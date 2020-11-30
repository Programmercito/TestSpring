package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.model.entities.SisEspecialidades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface IEspecialidades extends CrudRepository<SisEspecialidades, Integer> {

}
