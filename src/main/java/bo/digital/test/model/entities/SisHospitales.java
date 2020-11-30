/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "sis_hospitales")
@NamedQueries({
    @NamedQuery(name = "SisHospitales.findAll", query = "SELECT s FROM SisHospitales s"),
    @NamedQuery(name = "SisHospitales.findByIdHospitales", query = "SELECT s FROM SisHospitales s WHERE s.idHospitales = :idHospitales"),
    @NamedQuery(name = "SisHospitales.findByDescripcion", query = "SELECT s FROM SisHospitales s WHERE s.descripcion = :descripcion")})
public class SisHospitales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hospitales")
    private Integer idHospitales;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public SisHospitales() {
    }

    public SisHospitales(Integer idHospitales) {
        this.idHospitales = idHospitales;
    }

    public Integer getIdHospitales() {
        return idHospitales;
    }

    public void setIdHospitales(Integer idHospitales) {
        this.idHospitales = idHospitales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospitales != null ? idHospitales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisHospitales)) {
            return false;
        }
        SisHospitales other = (SisHospitales) object;
        if ((this.idHospitales == null && other.idHospitales != null) || (this.idHospitales != null && !this.idHospitales.equals(other.idHospitales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bugsy.SisHospitales[ idHospitales=" + idHospitales + " ]";
    }
    
}
