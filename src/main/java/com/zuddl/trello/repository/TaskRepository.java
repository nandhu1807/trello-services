package com.zuddl.trello.repository;

import com.zuddl.trello.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByTaskName(String taskName);

    List<Task> findByStages_StageId(Integer stageId);
}
