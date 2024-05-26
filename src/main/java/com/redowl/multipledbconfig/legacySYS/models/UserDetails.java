package com.redowl.multipledbconfig.legacySYS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_DETAILS", allocationSize = 1, sequenceName = "USER_DETAILS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_DETAILS")
    @Column(name = "USER_ID", nullable = false, length = 8)
    private Integer userId;

    @Column(name = "USER_CODE", nullable = false, length = 10)
    private String userCode;

    @Column(name = "CONTACT_NUMBER", length = 15)
    private String contactNumber;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "DATE_OF_JOIN")
    private LocalDate dateOfJoin;

    @Column(name = "NAME_WITH_INITIALS", length = 200)
    private String nameWithInitials;

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    private String middleName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "GENDER", length = 10)
    private String gender;

    @Column(name = "IDENTITY_NO", length = 20)
    private String identityNo;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "EMAIL", length = 100)
    private String email;
}
