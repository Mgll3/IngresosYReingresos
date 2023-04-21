package ingresos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A MatriculaSemestre.
 */
@Table("matricula_semestre")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MatriculaSemestre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("tipo_ingreso")
    private String tipoIngreso;

    @Column("tipo_aspirante")
    private String tipoAspirante;

    @Column("version")
    private String version;

    @Column("modalidad")
    private String modalidad;

    @Column("sede")
    private String sede;

    @Column("year")
    private Integer year;

    @Column("cohorte")
    private String cohorte;

    @Column("estado")
    private String estado;

    @Column("promedio_semestre")
    private Double promedioSemestre;

    @Column("promedio_acumulado")
    private Double promedioAcumulado;

    @Column("liquidacion_matricula")
    private String liquidacionMatricula;

    @Column("estado_pago")
    private String estadoPago;

    @Column("situacion_academica")
    private String situacionAcademica;

    @Transient
    private Programa matriculaS;

    @Transient
    @JsonIgnoreProperties(value = { "academica", "matriculaSemestres", "otroEstudioFormals" }, allowSetters = true)
    private InfoAcademica matriculaA;

    @Column("matriculas_id")
    private Long matriculaSId;

    @Column("matriculaa_id")
    private Long matriculaAId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public MatriculaSemestre id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIngreso() {
        return this.tipoIngreso;
    }

    public MatriculaSemestre tipoIngreso(String tipoIngreso) {
        this.setTipoIngreso(tipoIngreso);
        return this;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getTipoAspirante() {
        return this.tipoAspirante;
    }

    public MatriculaSemestre tipoAspirante(String tipoAspirante) {
        this.setTipoAspirante(tipoAspirante);
        return this;
    }

    public void setTipoAspirante(String tipoAspirante) {
        this.tipoAspirante = tipoAspirante;
    }

    public String getVersion() {
        return this.version;
    }

    public MatriculaSemestre version(String version) {
        this.setVersion(version);
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public MatriculaSemestre modalidad(String modalidad) {
        this.setModalidad(modalidad);
        return this;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getSede() {
        return this.sede;
    }

    public MatriculaSemestre sede(String sede) {
        this.setSede(sede);
        return this;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Integer getYear() {
        return this.year;
    }

    public MatriculaSemestre year(Integer year) {
        this.setYear(year);
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCohorte() {
        return this.cohorte;
    }

    public MatriculaSemestre cohorte(String cohorte) {
        this.setCohorte(cohorte);
        return this;
    }

    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    public String getEstado() {
        return this.estado;
    }

    public MatriculaSemestre estado(String estado) {
        this.setEstado(estado);
        return this;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPromedioSemestre() {
        return this.promedioSemestre;
    }

    public MatriculaSemestre promedioSemestre(Double promedioSemestre) {
        this.setPromedioSemestre(promedioSemestre);
        return this;
    }

    public void setPromedioSemestre(Double promedioSemestre) {
        this.promedioSemestre = promedioSemestre;
    }

    public Double getPromedioAcumulado() {
        return this.promedioAcumulado;
    }

    public MatriculaSemestre promedioAcumulado(Double promedioAcumulado) {
        this.setPromedioAcumulado(promedioAcumulado);
        return this;
    }

    public void setPromedioAcumulado(Double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getLiquidacionMatricula() {
        return this.liquidacionMatricula;
    }

    public MatriculaSemestre liquidacionMatricula(String liquidacionMatricula) {
        this.setLiquidacionMatricula(liquidacionMatricula);
        return this;
    }

    public void setLiquidacionMatricula(String liquidacionMatricula) {
        this.liquidacionMatricula = liquidacionMatricula;
    }

    public String getEstadoPago() {
        return this.estadoPago;
    }

    public MatriculaSemestre estadoPago(String estadoPago) {
        this.setEstadoPago(estadoPago);
        return this;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getSituacionAcademica() {
        return this.situacionAcademica;
    }

    public MatriculaSemestre situacionAcademica(String situacionAcademica) {
        this.setSituacionAcademica(situacionAcademica);
        return this;
    }

    public void setSituacionAcademica(String situacionAcademica) {
        this.situacionAcademica = situacionAcademica;
    }

    public Programa getMatriculaS() {
        return this.matriculaS;
    }

    public void setMatriculaS(Programa programa) {
        this.matriculaS = programa;
        this.matriculaSId = programa != null ? programa.getId() : null;
    }

    public MatriculaSemestre matriculaS(Programa programa) {
        this.setMatriculaS(programa);
        return this;
    }

    public InfoAcademica getMatriculaA() {
        return this.matriculaA;
    }

    public void setMatriculaA(InfoAcademica infoAcademica) {
        this.matriculaA = infoAcademica;
        this.matriculaAId = infoAcademica != null ? infoAcademica.getId() : null;
    }

    public MatriculaSemestre matriculaA(InfoAcademica infoAcademica) {
        this.setMatriculaA(infoAcademica);
        return this;
    }

    public Long getMatriculaSId() {
        return this.matriculaSId;
    }

    public void setMatriculaSId(Long programa) {
        this.matriculaSId = programa;
    }

    public Long getMatriculaAId() {
        return this.matriculaAId;
    }

    public void setMatriculaAId(Long infoAcademica) {
        this.matriculaAId = infoAcademica;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MatriculaSemestre)) {
            return false;
        }
        return id != null && id.equals(((MatriculaSemestre) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MatriculaSemestre{" +
            "id=" + getId() +
            ", tipoIngreso='" + getTipoIngreso() + "'" +
            ", tipoAspirante='" + getTipoAspirante() + "'" +
            ", version='" + getVersion() + "'" +
            ", modalidad='" + getModalidad() + "'" +
            ", sede='" + getSede() + "'" +
            ", year=" + getYear() +
            ", cohorte='" + getCohorte() + "'" +
            ", estado='" + getEstado() + "'" +
            ", promedioSemestre=" + getPromedioSemestre() +
            ", promedioAcumulado=" + getPromedioAcumulado() +
            ", liquidacionMatricula='" + getLiquidacionMatricula() + "'" +
            ", estadoPago='" + getEstadoPago() + "'" +
            ", situacionAcademica='" + getSituacionAcademica() + "'" +
            "}";
    }
}
