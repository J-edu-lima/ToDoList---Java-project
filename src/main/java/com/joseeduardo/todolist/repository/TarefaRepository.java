package com.joseeduardo.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseeduardo.todolist.entity.TarefaEntity;
import com.joseeduardo.todolist.entity.enums.Status;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

	List<TarefaEntity> findByStatus(Status status);

}
