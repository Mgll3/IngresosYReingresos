package ingresos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A OtroEstudioFormal.
 */
@Table("otro_estudio_formal")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OtroEstudioFormal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("institucion")
    private String institucion;

    @Column("estudio")
    private Long estudio;

    @Column("graduado")
    private Boolean graduado;

    @Column("year")
    private Integer year;

    @Column("titulo_obtenido")
    private String tituloObtenido;

    @Column("nivel")
    private String nivel;

    @Transient
    @JsonIgnoreProperties(value = { "academica", "matriculaSemestres", "otroEstudioFormals" }, allowSetters = true)
    private InfoAcademica otroFormal;

    @Column("otro_formal_id")
    private Long otroFormalId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public OtroEstudioFormal id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public OtroEstudioFormal institucion(String institucion) {
        this.setInstitucion(institucion);
        return this;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Long getEstudio() {
        return this.estudio;
    }

    public OtroEstudioFormal estudio(Long estudio) {
        this.setEstudio(estudio);
        return this;
    }

    public void setEstudio(Long estudio) {
        this.estudio = estudio;
    }

    public Boolean getGraduado() {
        return this.graduado;
    }

    public OtroEstudioFormal graduado(Boolean graduado) {
        this.setGraduado(graduado);
        return this;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }

    public Integer getYear() {
        return this.year;
    }

    public OtroEstudioFormal year(Integer year) {
        this.setYear(year);
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTituloObtenido() {
        return this.tituloObtenido;
    }

    public OtroEstudioFormal tituloObtenido(String tituloObtenido) {
        this.setTituloObtenido(tituloObtenido);
        return this;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public String getNivel() {
        return this.nivel;
    }

    public OtroEstudioFormal nivel(String nivel) {
        this.setNivel(nivel);
        return this;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public InfoAcademica getOtroFormal() {
        return this.otroFormal;
    }

    public void setOtroFormal(InfoAcademica infoAcademica) {
        this.otroFormal = infoAcademica;
        this.otroFormalId = infoAcademica != null ? infoAcademica.getId() : null;
    }

    public OtroEstudioFormal otroFormal(InfoAcademica infoAcademica) {
        this.setOtroFormal(infoAcademica);
        return this;
    }

    public Long getOtroFormalId() {
        return this.otroFormalId;
    }

    public void setOtroFormalId(Long infoAcademica) {
        this.otroFormalId = infoAcademica;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OtroEstudioFormal)) {
            return false;
        }
        return id != null && id.equals(((OtroEstudioFormal) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OtroEstudioFormal{" +
            "id=" + getId() +
            ", institucion='" + getInstitucion() + "'" +
            ", estudio=" + getEstudio() +
            ", graduado='" + getGraduado() + "'" +
            ", year=" + getYear() +
            ", tituloObtenido='" + getTituloObtenido() + "'" +
            ", nivel='" + getNivel() + "'" +
            "}";
    }
}
