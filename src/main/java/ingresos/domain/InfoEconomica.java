package ingresos.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A InfoEconomica.
 */
@Table("info_economica")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InfoEconomica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("direccion")
    private String direccion;

    @Column("barrio")
    private String barrio;

    @Column("ciudad")
    private String ciudad;

    @Column("departmento")
    private String departmento;

    @Column("estrato")
    private Integer estrato;

    @Column("depende_econo")
    private Boolean dependeEcono;

    @Column("trabaja")
    private Boolean trabaja;

    @Column("tiene_dependientes")
    private Boolean tieneDependientes;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public InfoEconomica id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public InfoEconomica direccion(String direccion) {
        this.setDireccion(direccion);
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public InfoEconomica barrio(String barrio) {
        this.setBarrio(barrio);
        return this;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public InfoEconomica ciudad(String ciudad) {
        this.setCiudad(ciudad);
        return this;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartmento() {
        return this.departmento;
    }

    public InfoEconomica departmento(String departmento) {
        this.setDepartmento(departmento);
        return this;
    }

    public void setDepartmento(String departmento) {
        this.departmento = departmento;
    }

    public Integer getEstrato() {
        return this.estrato;
    }

    public InfoEconomica estrato(Integer estrato) {
        this.setEstrato(estrato);
        return this;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

    public Boolean getDependeEcono() {
        return this.dependeEcono;
    }

    public InfoEconomica dependeEcono(Boolean dependeEcono) {
        this.setDependeEcono(dependeEcono);
        return this;
    }

    public void setDependeEcono(Boolean dependeEcono) {
        this.dependeEcono = dependeEcono;
    }

    public Boolean getTrabaja() {
        return this.trabaja;
    }

    public InfoEconomica trabaja(Boolean trabaja) {
        this.setTrabaja(trabaja);
        return this;
    }

    public void setTrabaja(Boolean trabaja) {
        this.trabaja = trabaja;
    }

    public Boolean getTieneDependientes() {
        return this.tieneDependientes;
    }

    public InfoEconomica tieneDependientes(Boolean tieneDependientes) {
        this.setTieneDependientes(tieneDependientes);
        return this;
    }

    public void setTieneDependientes(Boolean tieneDependientes) {
        this.tieneDependientes = tieneDependientes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoEconomica)) {
            return false;
        }
        return id != null && id.equals(((InfoEconomica) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InfoEconomica{" +
            "id=" + getId() +
            ", direccion='" + getDireccion() + "'" +
            ", barrio='" + getBarrio() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", departmento='" + getDepartmento() + "'" +
            ", estrato=" + getEstrato() +
            ", dependeEcono='" + getDependeEcono() + "'" +
            ", trabaja='" + getTrabaja() + "'" +
            ", tieneDependientes='" + getTieneDependientes() + "'" +
            "}";
    }
}
