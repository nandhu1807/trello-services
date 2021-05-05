package com.zuddl.trello.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TASK_HISTORY")
public class TaskHistory implements Serializable {
    @Id
    @Column(name = "Task_History_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_history_sequence")
    @SequenceGenerator(name = "task_history_sequence", sequenceName = "task_history_sequence", allocationSize = 100)
    private Integer taskHistoryId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Task_ID", referencedColumnName = "Task_ID")
    private Task task;

    @Column(name = "Assigned_To")
    private String assignedTo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Stage_ID", referencedColumnName = "Stage_ID")
    private Stages stages;

    @Column(name = "Last_Stage")
    private String lastStage;

    @Column(name = "Last_Assigned")
    private String lastAssigned;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private LocalDateTime createdOn;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Updated_On")
    private LocalDateTime updatedOn;
}
