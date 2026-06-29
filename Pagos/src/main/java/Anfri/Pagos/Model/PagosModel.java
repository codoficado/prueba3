package Anfri.Pagos.Model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagos")
public class PagosModel { // Se llama PagosModel para coincidir con tu Controller y Repository

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clienteId;
    private Integer pedidoId;
    private Double monto;
    private String metodoPago;
    private String estado;
    private LocalDateTime fechaPago;
}