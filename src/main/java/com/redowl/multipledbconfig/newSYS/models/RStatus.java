package com.redowl.multipledbconfig.newSYS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "R_STATUS")
public class RStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "R_STATUS", allocationSize = 1, sequenceName = "R_STATUS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_STATUS")
    @Column(name = "STATUS_ID", nullable = false, length = 8)
    private Integer statusId;

    @Column(name = "STATUS_CODE", nullable = false, length = 10)
    private String statusCode;

    @Column(name = "DESCRIPTION", length = 150)
    private String description;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(mappedBy = "rStatus")
    private List<MMemberDetails> mMemberDetails;
}
