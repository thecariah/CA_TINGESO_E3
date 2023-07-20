package cl.tingeso.calculoNotasservice.services;

import cl.tingeso.calculoNotasservice.entities.CalculoNotasEntity;
import cl.tingeso.calculoNotasservice.models.PreguntaModel;
import cl.tingeso.calculoNotasservice.models.RespuestaModel;
import cl.tingeso.calculoNotasservice.repositories.CalculoNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@Service
public class CalculoNotasService {
    @Autowired
    private CalculoNotasRepository calculoNotasRepository;

    @Autowired
    RestTemplate restTemplate;

    public void guardarNota(Long tiempo_demorado, Long nota_final){
        CalculoNotasEntity nota = new CalculoNotasEntity();

        nota.setTiempo_demorado(tiempo_demorado);
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

    public List<RespuestaModel> obtenerRespuestasPorPregunta(Long pregunta_id){
        List<RespuestaModel> respuestas = restTemplate.getForObject("http://respuesta-service/respuestas/pregunta/" + pregunta_id, List.class);
        System.out.println(respuestas);
        return respuestas;
    }

    public List<PreguntaModel> obtenerPreguntasAleatorias(List<PreguntaModel> repoPreguntas, Integer cantPreguntas){
        Collections.shuffle(repoPreguntas);
        return repoPreguntas.subList(0, cantPreguntas));
    }

    public void calcularNota(List<PreguntaModel> preguntasAleatorias, List<RespuestaModel> respuestasUsuario){
        //List<RespuestaModel> respuestas = obtenerRespuestasPorPregunta();

    }

    public void iniciarTestPython(String nivel){


    }




}
