package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisEspecialidades;
import bo.digital.test.model.entities.SisHospitales;
import bo.digital.test.model.entities.SisNotas;
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
public interface INotas extends CrudRepository<SisNotas, Integer>, PagingAndSortingRepository<SisNotas, Integer> {

    @Query(value = "select * from bugsy.sis_notas where id_paciente=:paciente", nativeQuery = true)
    public List<SisNotas> listarbyPaciente(@Param("paciente") Integer paciente);

}
