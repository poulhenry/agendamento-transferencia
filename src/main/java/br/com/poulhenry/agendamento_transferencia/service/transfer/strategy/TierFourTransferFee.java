package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// De 31 até 40 dias
@Component
public class TierFourTransferFee implements TransferFeeStrategy{
    @Override
    public boolean isApplicable(long day) {
        return day >= 31 && day <= 40;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = (value.doubleValue() * 4.7 / 100);
        return value.add(BigDecimal.valueOf(tax));
    }
}
