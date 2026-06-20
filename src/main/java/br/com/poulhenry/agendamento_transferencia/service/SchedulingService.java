package br.com.poulhenry.agendamento_transferencia.service;

import br.com.poulhenry.agendamento_transferencia.dto.CreateScheduleRequest;
import br.com.poulhenry.agendamento_transferencia.dto.SchedulingResponse;
import br.com.poulhenry.agendamento_transferencia.entity.Scheduling;
import br.com.poulhenry.agendamento_transferencia.repository.SchedulingRepository;
import br.com.poulhenry.agendamento_transferencia.service.transfer.factory.TransferFeeFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedulingService {
    private final TransferFeeFactory factory;
    private final SchedulingRepository repository;

    public SchedulingService(TransferFeeFactory factory, SchedulingRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public List<SchedulingResponse> listAll() {
        return this.repository
                .findAll()
                .stream()
                .map(SchedulingResponse::from)
                .collect(Collectors.toList());
    }

    public SchedulingResponse schedule(CreateScheduleRequest request) {
        var differentDays = ChronoUnit.DAYS.between(LocalDate.now(), request.getSchedulingDate());

        var tier = factory.getTierTransferStrategy(differentDays);
        var tax = tier.calculate(request.getValue());

        Scheduling scheduling = new Scheduling(
                request.getOriginAccount(),
                request.getDestinationAccount(),
                request.getValue(),
                tax,
                LocalDate.now(),
                request.getSchedulingDate());

        this.repository.save(scheduling);
        return SchedulingResponse.from(scheduling);
    }
}
