package ingresos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A InfoAcademica.
 */
@Table("info_academica")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InfoAcademica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Transient
    private InfoBachillerato academica;

    @Transient
    @JsonIgnoreProperties(value = { "matriculaS", "matriculaA" }, allowSetters = true)
    private Set<MatriculaSemestre> matriculaSemestres = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "otroFormal" }, allowSetters = true)
    private Set<OtroEstudioFormal> otroEstudioFormals = new HashSet<>();

    @Column("academica_id")
    private Long academicaId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public InfoAcademica id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InfoBachillerato getAcademica() {
        return this.academica;
    }

    public void setAcademica(InfoBachillerato infoBachillerato) {
        this.academica = infoBachillerato;
        this.academicaId = infoBachillerato != null ? infoBachillerato.getId() : null;
    }

    public InfoAcademica academica(InfoBachillerato infoBachillerato) {
        this.setAcademica(infoBachillerato);
        return this;
    }

    public Set<MatriculaSemestre> getMatriculaSemestres() {
        return this.matriculaSemestres;
    }

    public void setMatriculaSemestres(Set<MatriculaSemestre> matriculaSemestres) {
        if (this.matriculaSemestres != null) {
            this.matriculaSemestres.forEach(i -> i.setMatriculaA(null));
        }
        if (matriculaSemestres != null) {
            matriculaSemestres.forEach(i -> i.setMatriculaA(this));
        }
        this.matriculaSemestres = matriculaSemestres;
    }

    public InfoAcademica matriculaSemestres(Set<MatriculaSemestre> matriculaSemestres) {
        this.setMatriculaSemestres(matriculaSemestres);
        return this;
    }

    public InfoAcademica addMatriculaSemestre(MatriculaSemestre matriculaSemestre) {
        this.matriculaSemestres.add(matriculaSemestre);
        matriculaSemestre.setMatriculaA(this);
        return this;
    }

    public InfoAcademica removeMatriculaSemestre(MatriculaSemestre matriculaSemestre) {
        this.matriculaSemestres.remove(matriculaSemestre);
        matriculaSemestre.setMatriculaA(null);
        return this;
    }

    public Set<OtroEstudioFormal> getOtroEstudioFormals() {
        return this.otroEstudioFormals;
    }

    public void setOtroEstudioFormals(Set<OtroEstudioFormal> otroEstudioFormals) {
        if (this.otroEstudioFormals != null) {
            this.otroEstudioFormals.forEach(i -> i.setOtroFormal(null));
        }
        if (otroEstudioFormals != null) {
            otroEstudioFormals.forEach(i -> i.setOtroFormal(this));
        }
        this.otroEstudioFormals = otroEstudioFormals;
    }

    public InfoAcademica otroEstudioFormals(Set<OtroEstudioFormal> otroEstudioFormals) {
        this.setOtroEstudioFormals(otroEstudioFormals);
        return this;
    }

    public InfoAcademica addOtroEstudioFormal(OtroEstudioFormal otroEstudioFormal) {
        this.otroEstudioFormals.add(otroEstudioFormal);
        otroEstudioFormal.setOtroFormal(this);
        return this;
    }

    public InfoAcademica removeOtroEstudioFormal(OtroEstudioFormal otroEstudioFormal) {
        this.otroEstudioFormals.remove(otroEstudioFormal);
        otroEstudioFormal.setOtroFormal(null);
        return this;
    }

    public Long getAcademicaId() {
        return this.academicaId;
    }

    public void setAcademicaId(Long infoBachillerato) {
        this.academicaId = infoBachillerato;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoAcademica)) {
            return false;
        }
        return id != null && id.equals(((InfoAcademica) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InfoAcademica{" +
            "id=" + getId() +
            "}";
    }
}
