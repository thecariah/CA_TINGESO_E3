package cl.tingeso.calculoNotasservice.controllers;

import cl.tingeso.calculoNotasservice.entities.CalculoNotasEntity;
import cl.tingeso.calculoNotasservice.services.CalculoNotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class CalculoNotasController {
    @Autowired
    private CalculoNotasService calculoNotasService;

    @GetMapping
    public ResponseEntity<List<CalculoNotasEntity>> getAllNotas(){
        List<CalculoNotasEntity> notas = calculoNotasService.obtenerNotas();
        if(notas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CalculoNotasEntity> getNota(@PathVariable("id") Long id) {
        CalculoNotasEntity nota = calculoNotasService.obtenerNotasPorId(id);
        if(nota == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nota);
    }

    @GetMapping("/delete")
    public void deleteNotas(){
        calculoNotasService.borrarNotas();
    }

    @PostMapping("/new")
    public String createNota(@RequestParam("nota_final") double nota_final){
        calculoNotasService.guardarNota(nota_final);
        return "redirect:/notas/new";
    }

}
