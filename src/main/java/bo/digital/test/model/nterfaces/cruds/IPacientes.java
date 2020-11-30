
package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisPaciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface IPacientes extends CrudRepository<SisPaciente, Integer> {

}
