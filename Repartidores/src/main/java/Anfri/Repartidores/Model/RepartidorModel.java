package Anfri.Repartidores.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "repartidores")
public class RepartidorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String telefono;
    private String tipoVehiculo;
    private String estado;

    public RepartidorModel() {}

    public RepartidorModel(Integer id, String nombre, String telefono, String tipoVehiculo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoVehiculo = tipoVehiculo;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}