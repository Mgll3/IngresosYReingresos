package ingresos.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A InfoBachillerato.
 */
@Table("info_bachillerato")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InfoBachillerato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("ciudad")
    private String ciudad;

    @Column("departamento")
    private String departamento;

    @Column("pais")
    private String pais;

    @Column("colegio")
    private String colegio;

    @Column("year")
    private Integer year;

    @Column("modalidad")
    private String modalidad;

    @Column("puntaje_icfes")
    private Integer puntajeIcfes;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public InfoBachillerato id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public InfoBachillerato ciudad(String ciudad) {
        this.setCiudad(ciudad);
        return this;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public InfoBachillerato departamento(String departamento) {
        this.setDepartamento(departamento);
        return this;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return this.pais;
    }

    public InfoBachillerato pais(String pais) {
        this.setPais(pais);
        return this;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColegio() {
        return this.colegio;
    }

    public InfoBachillerato colegio(String colegio) {
        this.setColegio(colegio);
        return this;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public Integer getYear() {
        return this.year;
    }

    public InfoBachillerato year(Integer year) {
        this.setYear(year);
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public InfoBachillerato modalidad(String modalidad) {
        this.setModalidad(modalidad);
        return this;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getPuntajeIcfes() {
        return this.puntajeIcfes;
    }

    public InfoBachillerato puntajeIcfes(Integer puntajeIcfes) {
        this.setPuntajeIcfes(puntajeIcfes);
        return this;
    }

    public void setPuntajeIcfes(Integer puntajeIcfes) {
        this.puntajeIcfes = puntajeIcfes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoBachillerato)) {
            return false;
        }
        return id != null && id.equals(((InfoBachillerato) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InfoBachillerato{" +
            "id=" + getId() +
            ", ciudad='" + getCiudad() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            ", pais='" + getPais() + "'" +
            ", colegio='" + getColegio() + "'" +
            ", year=" + getYear() +
            ", modalidad='" + getModalidad() + "'" +
            ", puntajeIcfes=" + getPuntajeIcfes() +
            "}";
    }
}
