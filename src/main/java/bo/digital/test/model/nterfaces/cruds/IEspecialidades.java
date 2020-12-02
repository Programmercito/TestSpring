package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.model.entities.SisEspecialidades;
import bo.digital.test.model.entities.SisPaciente;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface IEspecialidades extends CrudRepository<SisEspecialidades, Integer>, PagingAndSortingRepository <SisEspecialidades, Integer> {
    
    @Query(value = "select * from bugsy.sis_especialidades where id_doctor=:doctor", nativeQuery = true)
    public List<SisEspecialidades> listarDoctor(@Param("doctor") Integer doctor);

}
