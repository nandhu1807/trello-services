package com.zuddl.trello.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "STAGES")
public class Stages implements Serializable {
    @Id
    @Column(name = "Stage_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stage_sequence")
    @SequenceGenerator(name = "stage_sequence", sequenceName = "stage_sequence", allocationSize = 100)
    private Integer stageId;

    @Column(name = "Stage_Name")
    private String stageName;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private LocalDateTime createdOn;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Updated_On")
    private LocalDateTime updatedOn;
}
