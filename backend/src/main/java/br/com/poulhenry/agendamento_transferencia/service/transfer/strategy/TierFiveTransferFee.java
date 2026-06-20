package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// De 41 até 50 dias
@Component
public class TierFiveTransferFee implements TransferFeeStrategy {
    @Override
    public boolean isApplicable(long day) {
        return day >= 41 && day <= 50;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = (value.doubleValue() * 1.7 / 100);
        return value.add(BigDecimal.valueOf(tax));
    }
}
