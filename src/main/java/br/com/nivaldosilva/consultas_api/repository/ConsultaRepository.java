package br.com.nivaldosilva.consultas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.nivaldosilva.consultas_api.model.ConsultaEntity;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

}
