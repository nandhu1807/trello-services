package com.zuddl.trello.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TASK")
public class Task implements Serializable {
    @Id
    @Column(name = "Task_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 100)
    private Integer taskId;

    @Column(name = "Task_Name")
    private String taskName;

    @Column(name = "Task_Desc")
    private String taskDesc;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Stage_Id", referencedColumnName = "Stage_Id")
    private Stages stages;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "Priority")
    private int priority;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private LocalDateTime createdOn;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Updated_On")
    private LocalDateTime updatedOn;
}
