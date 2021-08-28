package com.pacatovisk.ordemservico.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {

    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getErros() {
        return errors;
    }

    public void addErros(String fielName, String message) {
        this.errors.add(new FieldMessage(fielName, message));
    }
}
