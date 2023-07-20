package cl.tingeso.calculoNotasservice.repositories;

import cl.tingeso.calculoNotasservice.entities.CalculoNotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoNotasRepository extends JpaRepository<CalculoNotasEntity, Long> {
    //encontrar notas por id
    @Query("SELECT r FROM CalculoNotasEntity r WHERE r.id = :id")
    CalculoNotasEntity findNotasById(@Param("id") Long id);

}
