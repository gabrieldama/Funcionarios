package com.funcionarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 6, message = "O nome deve ter mais de 5 caracteres")
    private String name;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate birthDate;

    private String phone;

    @NotNull(message = "O departamento é obrigatório")
    @Enumerated(EnumType.STRING)
    private Department department;

    @NotNull(message = "O cargo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Role role;
}