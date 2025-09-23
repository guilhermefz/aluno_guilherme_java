package com.escola.ALUNO_guilherme.repository;

import com.escola.ALUNO_guilherme.models.AlunoModel;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends
        JpaRepository<AlunoModel, UUID> {
    void deleteById(SingularAttribute<AbstractPersistable, Serializable> id);

    List<AlunoModel> findByNomeContainingIgnoreCase(String nome);
}
