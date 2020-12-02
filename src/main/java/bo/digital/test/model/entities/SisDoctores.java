/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "sis_doctores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisDoctores.findAll", query = "SELECT s FROM SisDoctores s"),
    @NamedQuery(name = "SisDoctores.findByIdDoctor", query = "SELECT s FROM SisDoctores s WHERE s.idDoctor = :idDoctor"),
    @NamedQuery(name = "SisDoctores.findByNombre", query = "SELECT s FROM SisDoctores s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SisDoctores.findByApellido", query = "SELECT s FROM SisDoctores s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "SisDoctores.findByFechaNacimiento", query = "SELECT s FROM SisDoctores s WHERE s.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "SisDoctores.findByDireccion", query = "SELECT s FROM SisDoctores s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "SisDoctores.findByFotoDePerfil", query = "SELECT s FROM SisDoctores s WHERE s.fotoDePerfil = :fotoDePerfil"),
    @NamedQuery(name = "SisDoctores.findByFecCre", query = "SELECT s FROM SisDoctores s WHERE s.fecCre = :fecCre"),
    @NamedQuery(name = "SisDoctores.findByFecMod", query = "SELECT s FROM SisDoctores s WHERE s.fecMod = :fecMod"),
    @NamedQuery(name = "SisDoctores.findByUsuCre", query = "SELECT s FROM SisDoctores s WHERE s.usuCre = :usuCre"),
    @NamedQuery(name = "SisDoctores.findByUsuMod", query = "SELECT s FROM SisDoctores s WHERE s.usuMod = :usuMod")})
public class SisDoctores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doctor")
    private Integer idDoctor;
    @Size(max = 45)
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    @NotNull
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 450)
    @Column(name = "direccion")
    @NotNull
    private String direccion;
    @Size(max = 450)
    @Column(name = "foto_de_perfil")
    private String fotoDePerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_cre")
    @Temporal(TemporalType.DATE)
    private Date fecCre;
    @Column(name = "fec_mod")
    @Temporal(TemporalType.DATE)
    private Date fecMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usu_cre")
    private String usuCre;
    @Size(max = 45)
    @Column(name = "usu_mod")
    private String usuMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctor")
    private List<SisNotas> sisNotasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctor")
    private List<SisEspecialidades> sisEspecialidadesList;

    public SisDoctores() {
    }

    public SisDoctores(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public SisDoctores(Integer idDoctor, Date fecCre, String usuCre) {
        this.idDoctor = idDoctor;
        this.fecCre = fecCre;
        this.usuCre = usuCre;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFotoDePerfil() {
        return fotoDePerfil;
    }

    public void setFotoDePerfil(String fotoDePerfil) {
        this.fotoDePerfil = fotoDePerfil;
    }

    public Date getFecCre() {
        return fecCre;
    }

    public void setFecCre(Date fecCre) {
        this.fecCre = fecCre;
    }

    public Date getFecMod() {
        return fecMod;
    }

    public void setFecMod(Date fecMod) {
        this.fecMod = fecMod;
    }

    public String getUsuCre() {
        return usuCre;
    }

    public void setUsuCre(String usuCre) {
        this.usuCre = usuCre;
    }

    public String getUsuMod() {
        return usuMod;
    }

    public void setUsuMod(String usuMod) {
        this.usuMod = usuMod;
    }

    public List<SisNotas> getSisNotasList() {
        return sisNotasList;
    }

    public void setSisNotasList(List<SisNotas> sisNotasList) {
        this.sisNotasList = sisNotasList;
    }

    public List<SisEspecialidades> getSisEspecialidadesList() {
        return sisEspecialidadesList;
    }

    public void setSisEspecialidadesList(List<SisEspecialidades> sisEspecialidadesList) {
        this.sisEspecialidadesList = sisEspecialidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoctor != null ? idDoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisDoctores)) {
            return false;
        }
        SisDoctores other = (SisDoctores) object;
        if ((this.idDoctor == null && other.idDoctor != null) || (this.idDoctor != null && !this.idDoctor.equals(other.idDoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.digital.test.model.entities.SisDoctores[ idDoctor=" + idDoctor + " ]";
    }

}
