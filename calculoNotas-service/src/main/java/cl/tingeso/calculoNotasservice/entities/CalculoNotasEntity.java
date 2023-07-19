package cl.tingeso.calculoNotasservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;

@Entity
@Table(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalculoNotasEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tiempo_demorado;
    private Long nota_final;
}