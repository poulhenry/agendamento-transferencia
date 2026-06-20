package br.com.poulhenry.agendamento_transferencia.repository;

import br.com.poulhenry.agendamento_transferencia.entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
