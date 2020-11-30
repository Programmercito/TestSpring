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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "sis_notas")
@NamedQueries({
    @NamedQuery(name = "SisNotas.findAll", query = "SELECT s FROM SisNotas s"),
    @NamedQuery(name = "SisNotas.findByIdNotas", query = "SELECT s FROM SisNotas s WHERE s.idNotas = :idNotas"),
    @NamedQuery(name = "SisNotas.findByDescripcion", query = "SELECT s FROM SisNotas s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SisNotas.findByFecha", query = "SELECT s FROM SisNotas s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SisNotas.findByFecCre", query = "SELECT s FROM SisNotas s WHERE s.fecCre = :fecCre"),
    @NamedQuery(name = "SisNotas.findByFecMod", query = "SELECT s FROM SisNotas s WHERE s.fecMod = :fecMod"),
    @NamedQuery(name = "SisNotas.findByUsuCre", query = "SELECT s FROM SisNotas s WHERE s.usuCre = :usuCre")})
public class SisNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_notas")
    private Integer idNotas;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fec_cre")
    @Temporal(TemporalType.DATE)
    private Date fecCre;
    @Column(name = "fec_mod")
    @Temporal(TemporalType.DATE)
    private Date fecMod;
    @Size(max = 45)
    @Column(name = "usu_cre")
    private String usuCre;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private SisPaciente idPaciente;

    public SisNotas() {
    }

    public SisNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public SisPaciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(SisPaciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisNotas)) {
            return false;
        }
        SisNotas other = (SisNotas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bugsy.SisNotas[ idNotas=" + idNotas + " ]";
    }
    
}
