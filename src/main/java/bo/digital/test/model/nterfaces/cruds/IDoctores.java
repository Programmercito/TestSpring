package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisDoctores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface IDoctores extends CrudRepository<SisDoctores, Integer> {

}
