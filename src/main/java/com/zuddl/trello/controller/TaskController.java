package com.zuddl.trello.controller;

import com.zuddl.trello.dto.TaskDTO;
import com.zuddl.trello.model.Task;
import com.zuddl.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/tasks/all")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> taskList = taskService.getAllTask();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<String> addNewTask(@RequestBody TaskDTO taskDTO) {
        String message = taskService.addNewTask(taskDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePriority")
    public ResponseEntity<String> updatePriority(@RequestBody List<Task> taskList) {
        String message = taskService.updateTaskPriority(taskList);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
