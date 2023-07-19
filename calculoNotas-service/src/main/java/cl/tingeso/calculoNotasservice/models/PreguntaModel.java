package cl.tingeso.calculoNotasservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaModel {
    private String nivel;
    private String resp_correcta;
    private String link_img;
}
