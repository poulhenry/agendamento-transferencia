package br.com.poulhenry.agendamento_transferencia.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "scheduling")
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_account", nullable = false)
    private String originAccount;

    @Column(name = "destination_account", nullable = false)
    private String destinationAccount;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private BigDecimal tax;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @Column(name = "scheduling_date", nullable = false)
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
