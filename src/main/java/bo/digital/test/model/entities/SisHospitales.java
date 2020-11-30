/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.test.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "sis_hospitales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisHospitales.findAll", query = "SELECT s FROM SisHospitales s"),
    @NamedQuery(name = "SisHospitales.findByIdHospitales", query = "SELECT s FROM SisHospitales s WHERE s.idHospitales = :idHospitales"),
    @NamedQuery(name = "SisHospitales.findByDescripcion", query = "SELECT s FROM SisHospitales s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SisHospitales.findByFecCre", query = "SELECT s FROM SisHospitales s WHERE s.fecCre = :fecCre"),
    @NamedQuery(name = "SisHospitales.findByFecMod", query = "SELECT s FROM SisHospitales s WHERE s.fecMod = :fecMod"),
    @NamedQuery(name = "SisHospitales.findByUsuCre", query = "SELECT s FROM SisHospitales s WHERE s.usuCre = :usuCre"),
    @NamedQuery(name = "SisHospitales.findByUsuMod", query = "SELECT s FROM SisHospitales s WHERE s.usuMod = :usuMod")})
public class SisHospitales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hospitales")
    private Integer idHospitales;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
   
    @Column(name = "fec_cre")
    @Temporal(TemporalType.DATE)
    private Date fecCre;
    @Column(name = "fec_mod")
    @Temporal(TemporalType.DATE)
    private Date fecMod;
    @Basic(optional = false)
 
    @Size(min = 1, max = 45)
    @Column(name = "usu_cre")
    private String usuCre;
    @Size(max = 45)
    @Column(name = "usu_mod")
    private String usuMod;

    public SisHospitales() {
    }

    public SisHospitales(Integer idHospitales) {
        this.idHospitales = idHospitales;
    }

    public SisHospitales(Integer idHospitales, Date fecCre, String usuCre) {
        this.idHospitales = idHospitales;
        this.fecCre = fecCre;
        this.usuCre = usuCre;
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
        return "bo.digital.test.model.entities.SisHospitales[ idHospitales=" + idHospitales + " ]";
    }
    
}
