package cl.tingeso.respuestaservice.controllers;

import cl.tingeso.respuestaservice.entities.RespuestaEntity;
import cl.tingeso.respuestaservice.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public ResponseEntity<List<RespuestaEntity>> getAllRespuestas(){
        List<RespuestaEntity> respuestas = respuestaService.obtenerRespuestas();
        if(respuestas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RespuestaEntity> getRespuesta(@PathVariable("id") Long id) {
        RespuestaEntity respuesta = respuestaService.obtenerRespuestaPorId(id);
        if(respuesta == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/pregunta/{pregunta_id}")
    public ResponseEntity<List<RespuestaEntity>> getRespuestasPorPregunta(@PathVariable("pregunta_id") Long pregunta_id){
        List<RespuestaEntity> respuestas = respuestaService.obtenerRespuestasPorPregunta(pregunta_id);
        if(respuestas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/delete")
    public void deleteRespuestas(){
        respuestaService.borrarRespuestas();
    }

    @PostMapping("/new")
    public String createRespuesta(@RequestParam("respuesta") String respuesta, @RequestParam("pregunta_id") Long pregunta_id){
        respuestaService.guardarRespuesta(respuesta, pregunta_id);
        return "redirect:/respuestas/new";
    }

}
