package cl.tingeso.preguntaservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;


@Entity
@Table(name = "preguntas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PreguntaEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nivel;
    private String resp_correcta;
    private String link_img;
}
