package com.zuddl.trello.repository;

import com.zuddl.trello.model.Stages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StagesRepository extends JpaRepository<Stages, Integer> {
    List<Stages> findAll();

    Stages findByStageId(Integer stageId);

    Stages findByStageName(String stageName);
}
