package com.zuddl.trello.service;

import com.zuddl.trello.model.Stages;

import java.util.List;

public interface StagesService {

    List<Stages> getAllStages();

    String addNewStage(Stages stages);

    String updateStatus(Stages stages);
}
