package com.joseeduardo.todoist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.enums.Status;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

	List<TarefaEntity> findByStatus(Status status);

}
