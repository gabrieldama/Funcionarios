package com.funcionarios.service;

import com.funcionarios.exception.*;
import com.funcionarios.model.Department;
import com.funcionarios.model.Funcionario;
import com.funcionarios.model.Role;
import com.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        if (repository.existsByCpf(funcionario.getCpf())) {
            throw new CpfJaCadastradoException(funcionario.getCpf());
        }
        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new EmailJaCadastradoException(funcionario.getEmail());
        }
        return repository.save(funcionario);
    }

    public void DelFuncionario (Long id){
        repository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException(id));
        repository.deleteById(id);
    }
}