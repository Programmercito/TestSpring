
package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisNotas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface INotas extends CrudRepository<SisNotas, Integer> , PagingAndSortingRepository <SisNotas, Integer> {
    
}
