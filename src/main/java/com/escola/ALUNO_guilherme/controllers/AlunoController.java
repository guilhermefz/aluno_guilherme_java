package com.escola.ALUNO_guilherme.controllers;

import com.escola.ALUNO_guilherme.dtos.AlunoDto;
import com.escola.ALUNO_guilherme.models.AlunoModel;
import com.escola.ALUNO_guilherme.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("meu-get")
    public String metodo1() {
        return "Produto Controller está ativo, isso é um teste teste1";
    }


    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(
            @RequestBody @Valid AlunoDto dto
    ) {

        AlunoModel produtoSalvo = alunoService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                produtoSalvo);
    }

    @RequestMapping("/listar")
    public List<AlunoModel> listar() {
        return AlunoService.listar();
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(
            @RequestBody @Valid AlunoDto dto,
            @PathVariable(value = "id") UUID id
    ) {

        try {
            AlunoModel produtoEditado = alunoService.atualizar(dto, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoEditado);
        } catch (Exception e) {
            //retorna error 500 com a mensagem de erro para o front
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }

    }

    @PostMapping("/apagar/{id}")
    public ResponseEntity<String> apagar(@PathVariable(value = "id") UUID id) {
        try{
            alunoService.delete(id);
            return ResponseEntity.ok("Dados do aluno apagado com sucesso!");
        }catch (Exception e) {
            //retorna error 500 com a mensagem de erro para o front
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }

    }

    @GetMapping("/buscar")
    public List<AlunoModel> buscar(@RequestParam String nomeBusca){
        return alunoService.buscarPorNome(nomeBusca);
    }
}
