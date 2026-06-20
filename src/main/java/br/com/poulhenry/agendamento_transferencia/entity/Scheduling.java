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

    public Scheduling(String originAccount, String destinationAccount, BigDecimal value, BigDecimal tax, LocalDate transferDate, LocalDate schedulingDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.tax = tax;
        this.transferDate = transferDate;
        this.schedulingDate = schedulingDate;
    }

    public Scheduling() {
    }

    public Long getId() {
        return id;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }
}
