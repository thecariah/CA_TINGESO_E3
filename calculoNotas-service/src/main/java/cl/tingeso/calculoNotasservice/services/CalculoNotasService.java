package cl.tingeso.calculoNotasservice.services;

import cl.tingeso.calculoNotasservice.entities.CalculoNotasEntity;
import cl.tingeso.calculoNotasservice.models.PreguntaModel;
import cl.tingeso.calculoNotasservice.models.RespuestaModel;
import cl.tingeso.calculoNotasservice.repositories.CalculoNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class CalculoNotasService {
    @Autowired
    private CalculoNotasRepository calculoNotasRepository;

    @Autowired
    RestTemplate restTemplate;

    public void guardarNota(double nota_final){
        CalculoNotasEntity nota = new CalculoNotasEntity();

        nota.setNota_final(nota_final);

        calculoNotasRepository.save(nota);
    }

    public void borrarNotas(){ calculoNotasRepository.deleteAll(); }

    public List<CalculoNotasEntity> obtenerNotas(){
        return calculoNotasRepository.findAll();
    }

    public CalculoNotasEntity obtenerNotasPorId(Long id){
        return this.calculoNotasRepository.findNotasById(id);
    }

    public List<PreguntaModel> obtenerPreguntasPorNivel(String nivel){
        List<PreguntaModel> preguntas = restTemplate.getForObject("http://pregunta-service/preguntas/nivel/" + nivel, List.class);
        System.out.println(preguntas);
        return preguntas;
    }

    public PreguntaModel obtenerPreguntaPorID(Long id){
        PreguntaModel pregunta = restTemplate.getForObject("http://pregunta-service/preguntas/get/" + id, PreguntaModel.class);
        System.out.println(pregunta);
        return pregunta;
    }
    public RespuestaModel obtenerRespuestaPorID(Long id){
        RespuestaModel respuesta = restTemplate.getForObject("http://respuesta-service/respuestas/get/" + id, RespuestaModel.class);
        System.out.println(respuesta);
        return respuesta;
    }

    public List<PreguntaModel> obtenerPreguntasAleatorias(String nivel, Integer cantPreguntas){
        List<PreguntaModel> repoPreguntas = obtenerPreguntasPorNivel(nivel);
        Collections.shuffle(repoPreguntas);
        return repoPreguntas.subList(0, cantPreguntas);
    }

    public double calcularPromedio(List<Double> listaNum){
        double acum = 0;

        for (Double num : listaNum) {
            acum += num;
        }

        return acum / listaNum.size();
    }

    public double calcularNotaFinal(List<RespuestaModel> respuestasUsuario){
        List<Double> notas = new ArrayList<>();

        for (RespuestaModel respuesta : respuestasUsuario){
            PreguntaModel pregunta = obtenerPreguntaPorID(respuesta.getPregunta_id());

            if (pregunta.getResp_correcta().equals(respuesta.getRespuesta())){
                notas.add(7.0);
            }
            else{
                notas.add(1.0);
            }
        }

        double notaFinal = calcularPromedio(notas);

        guardarNota(notaFinal);

        return notaFinal;
    }

}
