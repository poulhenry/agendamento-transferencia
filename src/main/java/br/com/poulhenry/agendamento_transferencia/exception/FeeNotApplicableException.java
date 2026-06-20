package br.com.poulhenry.agendamento_transferencia.exception;

public class FeeNotApplicableException extends RuntimeException {
    public FeeNotApplicableException(String message) {
        super(message);
    }
}
