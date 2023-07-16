package cl.tingeso.preguntaservice.controllers;

import cl.tingeso.preguntaservice.entities.PreguntaEntity;
import cl.tingeso.preguntaservice.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @GetMapping
    public ResponseEntity<List<PreguntaEntity>> getAllPreguntas(){
        List<PreguntaEntity> preguntas = preguntaService.obtenerPreguntas();
        if(preguntas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaEntity> getPregunta(@PathVariable("id") Long id) {
        PreguntaEntity pregunta = preguntaService.obtenerPreguntaPorId(id);
        if(pregunta == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pregunta);
    }

    @GetMapping("{nivel}")
    public ResponseEntity<List<PreguntaEntity>> getAllPreguntas(@PathVariable("nivel") String nivel){
        List<PreguntaEntity> preguntas = preguntaService.obtenerPreguntasPorNivel(nivel);
        if(preguntas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/delete")
    public void deletePreguntas(){
        preguntaService.borrarPreguntas();
    }

    @PostMapping("/new")
    public String createPregunta(@RequestParam("nivel") String nivel,
                               @RequestParam("resp_correcta") String resp_correcta,
                               @RequestParam("link_img") String link_img){

        preguntaService.guardarPregunta(nivel, resp_correcta, link_img);
        return "redirect:/preguntas/new";
    }

}
