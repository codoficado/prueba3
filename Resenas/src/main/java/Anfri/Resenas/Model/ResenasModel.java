package Anfri.Resenas.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resenas")
public class ResenasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clienteId;
    private Integer pedidoId; // O productoId, dependiendo de qué reseñen
    private Integer calificacion; // Ej: 1 a 5 estrellas
    private String comentario;
    private LocalDateTime fechaResena;
}