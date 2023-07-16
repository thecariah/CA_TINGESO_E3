package cl.tingeso.preguntaservice.repositories;

import cl.tingeso.preguntaservice.entities.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    //encontrar preguntas por id
    @Query("SELECT p FROM PreguntaEntity p WHERE p.id = :id")
    PreguntaEntity findPreguntaById(@Param("id") Long id);

    //encontrar preguntas por nivel
    @Query("SELECT p FROM PreguntaEntity p WHERE p.nivel = :nivel")
    List<PreguntaEntity> findPreguntaByNivel(@Param("nivel") String nivel);

}
