package com.funcionarios.exception;

public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(Long id) {
        super("Funcionário não encontrado. ID: " + id);
    }
}
