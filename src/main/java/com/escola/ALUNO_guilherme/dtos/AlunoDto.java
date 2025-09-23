package com.escola.ALUNO_guilherme.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlunoDto {
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    private String telefone;
    @NotBlank(message = "O campo curso é obrigatório")
    private String curso;
}
