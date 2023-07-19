package cl.tingeso.respuestaservice.repositories;

import cl.tingeso.respuestaservice.entities.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Long> {
    //encontrar respuestas por id
    @Query("SELECT r FROM RespuestaEntity r WHERE r.id = :id")
    RespuestaEntity findRespuestaById(@Param("id") Long id);

    //encontrar respuestas de una pregunta especifica
    @Query("SELECT r FROM RespuestaEntity r WHERE r.pregunta_id = :pregunta_id")
    List<RespuestaEntity> findRespuestaByPregunta(@Param("pregunta_id") Long pregunta_id);
}
