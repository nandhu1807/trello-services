package com.zuddl.trello.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private Integer taskId;
    private String taskName;
    private String taskDesc;
    private Integer stageId;
    private Boolean status;
    private Integer priority;
}
