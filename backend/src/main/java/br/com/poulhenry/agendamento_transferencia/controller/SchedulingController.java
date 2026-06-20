package br.com.poulhenry.agendamento_transferencia.controller;

import br.com.poulhenry.agendamento_transferencia.dto.CreateScheduleRequest;
import br.com.poulhenry.agendamento_transferencia.dto.SchedulingResponse;
import br.com.poulhenry.agendamento_transferencia.service.SchedulingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class SchedulingController {

    private final SchedulingService service;

    public SchedulingController(SchedulingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SchedulingResponse>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<SchedulingResponse> schedule(@Valid @RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.schedule(request));
    }
}
