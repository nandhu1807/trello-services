package com.zuddl.trello.service.impl;

import com.zuddl.trello.model.Stages;
import com.zuddl.trello.repository.StagesRepository;
import com.zuddl.trello.service.StagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StagesServiceImpl implements StagesService {

    @Autowired
    private StagesRepository stagesRepository;

    @Override
    public List<Stages> getAllStages() {
        List<Stages> stagesList = stagesRepository.findAll();
        return stagesList;
    }

    @Override
    public String addNewStage(Stages stages) {
        Stages alreadyExistingStages = stagesRepository.findByStageName(stages.getStageName().trim());
        if (alreadyExistingStages != null) {
            return "Stage Name Already Exists";
        }
        stages.setStageName(stages.getStageName().trim());
        stages.setCreatedBy("SYS");
        stages.setUpdatedBy("SYS");
        stages.setCreatedOn(LocalDateTime.now());
        stages.setUpdatedOn(LocalDateTime.now());
        stagesRepository.save(stages);
        return "Stage Saved Successfully";
    }

    @Override
    public String updateStatus(Stages stages) {
        Stages alreadyExistingStages = stagesRepository.findByStageId(stages.getStageId());
        if (alreadyExistingStages != null) {
            alreadyExistingStages.setStatus(stages.getStatus());
            alreadyExistingStages.setUpdatedBy("SYS");
            alreadyExistingStages.setUpdatedOn(LocalDateTime.now());
            stagesRepository.save(alreadyExistingStages);
            return "Status Updated Successfully";
        } else {
            return "Stage ID does not Exist";
        }
    }
}
