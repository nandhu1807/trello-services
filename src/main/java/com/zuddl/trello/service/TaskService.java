package com.zuddl.trello.service;

import com.zuddl.trello.dto.TaskDTO;
import com.zuddl.trello.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();

    String addNewTask(TaskDTO taskDTO);

    String updateTaskPriority(List<Task> taskList);
}
