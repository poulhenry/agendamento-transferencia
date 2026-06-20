package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// De 21 até 30 dias
@Component
public class TierThreeTransferFee implements TransferFeeStrategy{
    @Override
    public boolean isApplicable(long day) {
        return day >= 21 && day <= 30;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = (value.doubleValue() * 6.9 / 100);
        return value.add(BigDecimal.valueOf(tax));
    }
}
