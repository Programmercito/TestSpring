package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisDoctores;
import bo.digital.test.model.entities.SisNotas;
import bo.digital.test.model.entities.SisPaciente;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface IPacientes extends CrudRepository<SisPaciente, Integer>, PagingAndSortingRepository<SisPaciente, Integer> {

    @Query(value = "select * from bugsy.sis_paciente where sis_paciente.fecha_nacimiento=ifnull(:nacimiento,fecha_nacimiento) and (nombre like concat('%',ifnull(:nombre,nombre),'%') and apellido like concat('%',ifnull(:apellido,apellido),'%'))", nativeQuery = true)
    public Page<SisPaciente> buscaPacientes(@Param("nacimiento") Date nacimineto, @Param("nombre") String nombre, @Param("apellido") String apellido, Pageable pageable);

    @Query(value = "select * from bugsy.sis_paciente where sis_paciente.fecha_nacimiento=ifnull(:nacimiento,fecha_nacimiento) and (nombre like concat('%',ifnull(:nombre,nombre),'%') and apellido like concat('%',ifnull(:apellido,apellido),'%'))", nativeQuery = true)
    public List<SisPaciente> buscaPacientes(@Param("nacimiento") Date nacimineto, @Param("nombre") String nombre, @Param("apellido") String apellido);

}
