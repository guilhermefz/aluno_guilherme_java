package com.escola.ALUNO_guilherme.services;

import com.escola.ALUNO_guilherme.dtos.AlunoDto;
import com.escola.ALUNO_guilherme.models.AlunoModel;
import com.escola.ALUNO_guilherme.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {
    private static AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public AlunoModel create(AlunoDto dto) {
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(dto.getNome());
        aluno.setCurso(dto.getCurso());
        aluno.setTelefone(dto.getTelefone());
        return alunoRepository.save(aluno);
    }

    public static List<AlunoModel> listar() {
        return alunoRepository.findAll();
    }

    public AlunoModel atualizar(AlunoDto dto, UUID id) {
        AlunoModel existente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aluno não encontrado"));
        existente.setNome(dto.getNome());
        existente.setTelefone(dto.getTelefone());
        existente.setCurso(dto.getCurso());
        return alunoRepository.save(existente);
    }

    public void delete(UUID id) {
        AlunoModel existente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aluno não encontrado"));
        alunoRepository.delete(existente);
    }

    public List<AlunoModel> buscarPorNome(String nomeBusca) {
        return alunoRepository.findByNomeContainingIgnoreCase(nomeBusca);
    }
}
