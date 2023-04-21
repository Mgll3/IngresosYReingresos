package ingresos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A InfoPersonal.
 */
@Table("info_personal")
@JsonIgnoreProperties(value = { "new" })
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InfoPersonal implements Serializable, Persistable<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private String id;

    @Column("tipo_id")
    private String tipoID;

    @Column("nombre")
    private String nombre;

    @Column("apellidos")
    private String apellidos;

    @Column("genero")
    private String genero;

    @Column("fecha_nacimiento")
    private String fechaNacimiento;

    @Column("edad_ingreso")
    private Integer edadIngreso;

    @Column("telefono")
    private Integer telefono;

    @Column("celular")
    private Integer celular;

    @Column("correo_personal")
    private String correoPersonal;

    @Column("nacionalidad")
    private String nacionalidad;

    @Transient
    private boolean isPersisted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public InfoPersonal id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoID() {
        return this.tipoID;
    }

    public InfoPersonal tipoID(String tipoID) {
        this.setTipoID(tipoID);
        return this;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public InfoPersonal nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public InfoPersonal apellidos(String apellidos) {
        this.setApellidos(apellidos);
        return this;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return this.genero;
    }

    public InfoPersonal genero(String genero) {
        this.setGenero(genero);
        return this;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public InfoPersonal fechaNacimiento(String fechaNacimiento) {
        this.setFechaNacimiento(fechaNacimiento);
        return this;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdadIngreso() {
        return this.edadIngreso;
    }

    public InfoPersonal edadIngreso(Integer edadIngreso) {
        this.setEdadIngreso(edadIngreso);
        return this;
    }

    public void setEdadIngreso(Integer edadIngreso) {
        this.edadIngreso = edadIngreso;
    }

    public Integer getTelefono() {
        return this.telefono;
    }

    public InfoPersonal telefono(Integer telefono) {
        this.setTelefono(telefono);
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCelular() {
        return this.celular;
    }

    public InfoPersonal celular(Integer celular) {
        this.setCelular(celular);
        return this;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCorreoPersonal() {
        return this.correoPersonal;
    }

    public InfoPersonal correoPersonal(String correoPersonal) {
        this.setCorreoPersonal(correoPersonal);
        return this;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public InfoPersonal nacionalidad(String nacionalidad) {
        this.setNacionalidad(nacionalidad);
        return this;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Transient
    @Override
    public boolean isNew() {
        return !this.isPersisted;
    }

    public InfoPersonal setIsPersisted() {
        this.isPersisted = true;
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoPersonal)) {
            return false;
        }
        return id != null && id.equals(((InfoPersonal) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InfoPersonal{" +
            "id=" + getId() +
            ", tipoID='" + getTipoID() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", genero='" + getGenero() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", edadIngreso=" + getEdadIngreso() +
            ", telefono=" + getTelefono() +
            ", celular=" + getCelular() +
            ", correoPersonal='" + getCorreoPersonal() + "'" +
            ", nacionalidad='" + getNacionalidad() + "'" +
            "}";
    }
}
