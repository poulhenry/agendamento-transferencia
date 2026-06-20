package br.com.poulhenry.agendamento_transferencia.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "agendamentos")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private BigDecimal value;
    private BigDecimal tax;
    private LocalDate transferDate;
    private LocalDate schedulingDate;
}
