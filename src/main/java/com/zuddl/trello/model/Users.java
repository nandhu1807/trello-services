package com.zuddl.trello.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private LocalDateTime createdOn;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Updated_On")
    private LocalDateTime updatedOn;
}
