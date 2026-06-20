package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import java.math.BigDecimal;

public interface TransferFeeStrategy {
    boolean isApplicable(long day);
    BigDecimal calculate(BigDecimal value);
}
