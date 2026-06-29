package Anfri.Notificaciones.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificaciones")
public class NotificacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clienteId;
    private String mensaje;
    private String tipo; // Ej: EMAIL, SMS, PUSH
    private String estado; // Ej: ENVIADO, PENDIENTE
    private LocalDateTime fechaEnvio;
}