package cl.tingeso.preguntaservice.services;

import cl.tingeso.preguntaservice.entities.PreguntaEntity;
import cl.tingeso.preguntaservice.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {
    @Autowired
    PreguntaRepository preguntaRepository;

    public void guardarPregunta(String nivel, String resp_correcta, String link_img){
        PreguntaEntity pregunta = new PreguntaEntity();

        pregunta.setNivel(nivel);
        pregunta.setResp_correcta(resp_correcta);
        pregunta.setLink_img(link_img);

        preguntaRepository.save(pregunta);
    }

    public void borrarPreguntas(){ preguntaRepository.deleteAll(); }

    public List<PreguntaEntity> obtenerPreguntas(){
        return preguntaRepository.findAll();
    }

    public PreguntaEntity obtenerPreguntaPorId(Long id){
        return this.preguntaRepository.findPreguntaById(id);
    }

    public List<PreguntaEntity> obtenerPreguntasPorNivel(String nivel){
        return this.preguntaRepository.findPreguntaByNivel(nivel);
    }
}
