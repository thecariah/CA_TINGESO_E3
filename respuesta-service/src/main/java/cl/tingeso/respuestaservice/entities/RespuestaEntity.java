package cl.tingeso.respuestaservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;

@Entity
@Table(name = "respuestas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespuestaEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuesta;
    private Long pregunta_id;
}
