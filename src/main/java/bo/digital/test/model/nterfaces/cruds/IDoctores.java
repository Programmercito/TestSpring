package bo.digital.test.model.nterfaces.cruds;

import bo.digital.test.model.entities.SisDoctores;
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
public interface IDoctores extends CrudRepository<SisDoctores, Integer>, PagingAndSortingRepository<SisDoctores, Integer> {

    @Query(value = "select * from bugsy.sis_doctores where sis_doctores.fecha_nacimiento=ifnull(:nacimiento,fecha_nacimiento) and (nombre like concat('%',ifnull(:nombre,nombre),'%') and apellido like concat('%',ifnull(:apellido,apellido),'%'))", nativeQuery = true)
    public Page<SisDoctores> buscaDoctores(@Param("nacimiento") Date nacimineto, @Param("nombre") String nombre, @Param("apellido") String apellido, Pageable pageable);

    @Query(value = "select * from bugsy.sis_doctores where sis_doctores.fecha_nacimiento=ifnull(:nacimiento,fecha_nacimiento) and (nombre like concat('%',ifnull(:nombre,nombre),'%') and apellido like concat('%',ifnull(:apellido,apellido),'%'))", nativeQuery = true)
    public List<SisDoctores> buscaDoctores(@Param("nacimiento") Date nacimineto, @Param("nombre") String nombre, @Param("apellido") String apellido);

}
