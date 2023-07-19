package cl.tingeso.respuestaservice.services;

import cl.tingeso.respuestaservice.entities.RespuestaEntity;
import cl.tingeso.respuestaservice.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    RespuestaRepository respuestaRepository;

    public void guardarRespuesta(String respuesta, Long pregunta_id){
        RespuestaEntity respuestaEntity = new RespuestaEntity();

        respuestaEntity.setRespuesta(respuesta);
        respuestaEntity.setPregunta_id(pregunta_id);

        respuestaRepository.save(respuestaEntity);
    }

    public void borrarRespuestas(){ respuestaRepository.deleteAll(); }

    public List<RespuestaEntity> obtenerRespuestas(){
        return respuestaRepository.findAll();
    }

    public RespuestaEntity obtenerRespuestaPorId(Long id){
        return this.respuestaRepository.findRespuestaById(id);
    }

    public List<RespuestaEntity> obtenerRespuestasPorPregunta(Long pregunta_id){
        return this.respuestaRepository.findRespuestaByPregunta(pregunta_id);
    }
}
