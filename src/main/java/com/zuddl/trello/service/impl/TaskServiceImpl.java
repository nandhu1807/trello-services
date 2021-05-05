package com.zuddl.trello.service.impl;

import com.zuddl.trello.dto.TaskDTO;
import com.zuddl.trello.model.Stages;
import com.zuddl.trello.model.Task;
import com.zuddl.trello.repository.StagesRepository;
import com.zuddl.trello.repository.TaskRepository;
import com.zuddl.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StagesRepository stagesRepository;

    @Override
    public List<Task> getAllTask() {
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }

    @Override
    public String addNewTask(TaskDTO taskDTO) {
        Task alreadyExistingTask = taskRepository.findByTaskName(taskDTO.getTaskName());

        if (alreadyExistingTask != null)
            return "Task Name Already Exists";

        Stages stages = stagesRepository.findByStageId(taskDTO.getStageId());

        List<Task> taskList = taskRepository.findByStages_StageId(taskDTO.getStageId());

        Task task = new Task();
        task.setTaskName(taskDTO.getTaskName().trim());
        task.setTaskDesc(taskDTO.getTaskDesc().trim());
        task.setStages(stages);
        task.setStatus(true);
        task.setPriority(taskList.size() + 1);
        task.setCreatedBy("SYS");
        task.setUpdatedBy("SYS");
        task.setCreatedOn(LocalDateTime.now());
        task.setUpdatedOn(LocalDateTime.now());
        taskRepository.save(task);
        return "Task Saved Successfully";
    }

    @Override
    public String updateTaskPriority(List<Task> taskList) {
        taskList.forEach(task -> {
            task.setUpdatedBy("SYS");
            task.setUpdatedOn(LocalDateTime.now());
        });
        taskRepository.saveAll(taskList);
        return "Task Priority Updated Successfully";
    }
}
