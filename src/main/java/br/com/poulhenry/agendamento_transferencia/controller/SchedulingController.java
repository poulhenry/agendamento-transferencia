package br.com.poulhenry.agendamento_transferencia.controller;

import br.com.poulhenry.agendamento_transferencia.dto.CreateScheduleRequest;
import br.com.poulhenry.agendamento_transferencia.dto.SchedulingResponse;
import br.com.poulhenry.agendamento_transferencia.service.SchedulingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/agendamento")
public class SchedulingController {

    private final SchedulingService service;

    public SchedulingController(SchedulingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SchedulingResponse> schedule(@Valid @RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.schedule(request));
    }
}
