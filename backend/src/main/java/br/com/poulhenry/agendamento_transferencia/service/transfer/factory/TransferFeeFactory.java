package br.com.poulhenry.agendamento_transferencia.service.transfer.factory;

import br.com.poulhenry.agendamento_transferencia.exception.FeeNotApplicableException;
import br.com.poulhenry.agendamento_transferencia.service.transfer.strategy.TransferFeeStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferFeeFactory {
    private final List<TransferFeeStrategy> strategies;

    public TransferFeeFactory(List<TransferFeeStrategy> strategies) {
        this.strategies = strategies;
    }

    public TransferFeeStrategy getTierTransferStrategy(long day) {
        return this.strategies
                .stream()
                .filter(s -> s.isApplicable(day))
                .findFirst()
                .orElseThrow(() -> new FeeNotApplicableException("Não é permitido agendar uma transferência acima de 50 dias"));
    }
}
