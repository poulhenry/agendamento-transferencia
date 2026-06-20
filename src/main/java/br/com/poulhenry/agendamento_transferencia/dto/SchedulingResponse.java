package br.com.poulhenry.agendamento_transferencia.dto;

import br.com.poulhenry.agendamento_transferencia.entity.Scheduling;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SchedulingResponse {
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private BigDecimal value;
    private BigDecimal tax;
    private LocalDate schedulingDate;

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


}
