package com.escola.ALUNO_guilherme.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDto {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;
    private String telefone;
    @NotBlank(message = "O curso é obrigatório")
    @Size(min = 3, message = "O curso deve ter no mínimo 3 caracteres")
    private String curso;
}
