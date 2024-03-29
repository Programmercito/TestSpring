/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "sis_especialidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisEspecialidades.findAll", query = "SELECT s FROM SisEspecialidades s"),
    @NamedQuery(name = "SisEspecialidades.findByIdEspecialidad", query = "SELECT s FROM SisEspecialidades s WHERE s.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "SisEspecialidades.findByNombre", query = "SELECT s FROM SisEspecialidades s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SisEspecialidades.findByDescripcion", query = "SELECT s FROM SisEspecialidades s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SisEspecialidades.findByAvatar", query = "SELECT s FROM SisEspecialidades s WHERE s.avatar = :avatar"),
    @NamedQuery(name = "SisEspecialidades.findByFecCre", query = "SELECT s FROM SisEspecialidades s WHERE s.fecCre = :fecCre"),
    @NamedQuery(name = "SisEspecialidades.findByFecMod", query = "SELECT s FROM SisEspecialidades s WHERE s.fecMod = :fecMod"),
    @NamedQuery(name = "SisEspecialidades.findByUsuCre", query = "SELECT s FROM SisEspecialidades s WHERE s.usuCre = :usuCre"),
    @NamedQuery(name = "SisEspecialidades.findByUsuMod", query = "SELECT s FROM SisEspecialidades s WHERE s.usuMod = :usuMod")})
public class SisEspecialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;
    @Size(max = 45)
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Size(max = 450)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 450)
    @Column(name = "avatar")
    private String avatar;
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
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")
    @ManyToOne(optional = false)
    @JsonBackReference
    private SisDoctores idDoctor;
    @Transient
    private Integer doctor;

    public SisEspecialidades() {
    }

    public SisEspecialidades(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public SisEspecialidades(Integer idEspecialidad, Date fecCre, String usuCre) {
        this.idEspecialidad = idEspecialidad;
        this.fecCre = fecCre;
        this.usuCre = usuCre;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public SisDoctores getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(SisDoctores idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisEspecialidades)) {
            return false;
        }
        SisEspecialidades other = (SisEspecialidades) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.digital.test.model.entities.SisEspecialidades[ idEspecialidad=" + idEspecialidad + " ]";
    }

    /**
     * @return the doctor
     */
    public Integer getDoctor() {
        doctor = this.getIdDoctor().getIdDoctor();
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Integer doctor) {
        SisDoctores doc = new SisDoctores();
        doc.setIdDoctor(doctor);
        this.setIdDoctor(doc);
    }
}
