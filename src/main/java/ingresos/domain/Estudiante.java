package ingresos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Estudiante.
 */
@Table("estudiante")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Estudiante extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("diligenciado")
    private Boolean diligenciado;

    @Transient
    private InfoPersonal estudianteP;

    @Transient
    private InfoEconomica estudianteE;

    @Transient
    private InfoAcademica estudianteA;

    @Column("estudiantep_id")
    private String estudiantePId;

    @Column("estudiantee_id")
    private Long estudianteEId;

    @Column("estudiantea_id")
    private Long estudianteAId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Estudiante id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDiligenciado() {
        return this.diligenciado;
    }

    public Estudiante diligenciado(Boolean diligenciado) {
        this.setDiligenciado(diligenciado);
        return this;
    }

    public void setDiligenciado(Boolean diligenciado) {
        this.diligenciado = diligenciado;
    }

    public InfoPersonal getEstudianteP() {
        return this.estudianteP;
    }

    public void setEstudianteP(InfoPersonal infoPersonal) {
        this.estudianteP = infoPersonal;
        this.estudiantePId = infoPersonal != null ? infoPersonal.getId() : null;
    }

    public Estudiante estudianteP(InfoPersonal infoPersonal) {
        this.setEstudianteP(infoPersonal);
        return this;
    }

    public InfoEconomica getEstudianteE() {
        return this.estudianteE;
    }

    public void setEstudianteE(InfoEconomica infoEconomica) {
        this.estudianteE = infoEconomica;
        this.estudianteEId = infoEconomica != null ? infoEconomica.getId() : null;
    }

    public Estudiante estudianteE(InfoEconomica infoEconomica) {
        this.setEstudianteE(infoEconomica);
        return this;
    }

    public InfoAcademica getEstudianteA() {
        return this.estudianteA;
    }

    public void setEstudianteA(InfoAcademica infoAcademica) {
        this.estudianteA = infoAcademica;
        this.estudianteAId = infoAcademica != null ? infoAcademica.getId() : null;
    }

    public Estudiante estudianteA(InfoAcademica infoAcademica) {
        this.setEstudianteA(infoAcademica);
        return this;
    }

    public String getEstudiantePId() {
        return this.estudiantePId;
    }

    public void setEstudiantePId(String infoPersonal) {
        this.estudiantePId = infoPersonal;
    }

    public Long getEstudianteEId() {
        return this.estudianteEId;
    }

    public void setEstudianteEId(Long infoEconomica) {
        this.estudianteEId = infoEconomica;
    }

    public Long getEstudianteAId() {
        return this.estudianteAId;
    }

    public void setEstudianteAId(Long infoAcademica) {
        this.estudianteAId = infoAcademica;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estudiante)) {
            return false;
        }
        return id != null && id.equals(((Estudiante) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Estudiante{" +
            "id=" + getId() +
            ", diligenciado='" + getDiligenciado() + "'" +
            "}";
    }
}
