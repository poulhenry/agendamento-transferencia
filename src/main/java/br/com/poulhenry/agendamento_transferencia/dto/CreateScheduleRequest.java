package br.com.poulhenry.agendamento_transferencia.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateScheduleRequest {
    @NotNull(message = "A conta de origem é obrigatório")
    private String originAccount;
    @NotNull(message = "A conta de origem é obrigatório")
    private String destinationAccount;
    @NotNull(message = "O valor é obrigatório")
    private BigDecimal value;
    @NotNull(message = "A data de agendamento é obrigatório")
    private LocalDate schedulingDate;

    public String getOriginAccount() {
        return originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }
}
