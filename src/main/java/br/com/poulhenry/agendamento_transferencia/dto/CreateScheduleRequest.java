package br.com.poulhenry.agendamento_transferencia.dto;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateScheduleRequest {
    @NotNull(message = "A conta de origem é obrigatório")
    @NotBlank(message = "A conta de origem não pode estar em branco")
    private String originAccount;

    @NotNull(message = "A conta destino é obrigatório")
    @NotBlank(message = "A conta destino não pode estar em branco")
    private String destinationAccount;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal value;

    @NotNull(message = "A data de agendamento é obrigatório")
    @FutureOrPresent(message = "A data de agendamento não pode ser no passado")
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
