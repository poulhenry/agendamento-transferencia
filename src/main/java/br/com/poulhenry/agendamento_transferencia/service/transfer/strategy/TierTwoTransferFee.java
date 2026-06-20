package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// De 11 até 20 dias
@Component
public class TierTwoTransferFee implements TransferFeeStrategy{
    @Override
    public boolean isApplicable(long day) {
        return day >= 11 && day <= 20;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = (value.doubleValue() * 8.2 / 100);
        return value.add(BigDecimal.valueOf(tax));
    }
}
