
package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisEspecialidades;
import bo.digital.test.model.entities.SisHospitales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface IHospitales extends CrudRepository<SisHospitales, Integer> , PagingAndSortingRepository <SisHospitales, Integer> {
    
}
