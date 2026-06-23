package com.funcionarios.controller;

import com.funcionarios.model.Funcionario;
import com.funcionarios.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        return ResponseEntity.status(201).body(funcionarioService.criarFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DelFuncionario(@PathVariable Long id){
        funcionarioService.DelFuncionario(id);
        return  ResponseEntity.noContent().build();
    }
}