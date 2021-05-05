package com.zuddl.trello.controller;

import com.zuddl.trello.model.Stages;
import com.zuddl.trello.service.StagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StagesController {

    @Autowired
    private StagesService stagesService;

    @GetMapping(value = "/stages")
    public ResponseEntity<List<Stages>> getAllStages() {
        List<Stages> stagesList = stagesService.getAllStages();
        return new ResponseEntity<>(stagesList, HttpStatus.OK);
    }

    @PostMapping(value = "/addNewStage")
    public ResponseEntity<String> addNewStage(@RequestBody Stages stages) {
        String message = stagesService.addNewStage(stages);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/status")
    public ResponseEntity<String> updateStatus(@RequestBody Stages stages) {
        String message = stagesService.updateStatus(stages);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }
}
