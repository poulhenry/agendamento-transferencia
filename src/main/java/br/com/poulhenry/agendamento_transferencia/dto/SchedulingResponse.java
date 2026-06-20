package br.com.poulhenry.agendamento_transferencia.dto;

import br.com.poulhenry.agendamento_transferencia.entity.Scheduling;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SchedulingResponse {
    private final Long id;
    private final String originAccount;
    private final String destinationAccount;
    private final BigDecimal value;
    private final BigDecimal tax;
    private final LocalDate schedulingDate;

    public SchedulingResponse(Long id, String originAccount, String destinationAccount, BigDecimal value, BigDecimal tax, LocalDate schedulingDate) {
        this.id = id;
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.tax = tax;
        this.schedulingDate = schedulingDate;
    }

    public static SchedulingResponse from(Scheduling scheduling) {
        return new SchedulingResponse(
            scheduling.getId(),
                scheduling.getOriginAccount(),
                scheduling.getDestinationAccount(),
                scheduling.getValue(),
                scheduling.getTax(),
                scheduling.getSchedulingDate()
        );
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

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }
}
