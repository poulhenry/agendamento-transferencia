package br.com.poulhenry.agendamento_transferencia.service.transfer.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TierZeroTransferFee implements TransferFeeStrategy{
    @Override
    public boolean isApplicable(long day) {
        return day == 0;
    }

    @Override
    public BigDecimal calculate(BigDecimal value) {
        double tax = 3.0 + (value.doubleValue() * 2.5 / 100);
        return value.add(BigDecimal.valueOf(tax));
    }
}
