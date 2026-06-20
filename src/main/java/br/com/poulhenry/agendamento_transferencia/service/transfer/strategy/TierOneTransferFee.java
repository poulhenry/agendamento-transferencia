package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// De 1 até 10 dias
@Component
public class TierOneTransferFee implements TransferFeeStrategy{
    @Override
    public boolean isApplicable(long day) {
        return day >= 1 && day <= 10;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = 12.0 + value.doubleValue();
        return value.add(BigDecimal.valueOf(tax));
    }
}
