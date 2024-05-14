package com.redowl.multipledbconfig.newSYS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "M_MEMBER_DETAILS", indexes = {
        @Index(name = "M_MEMBER_DETAILS_LD_R_STATUS1_idx", columnList = "STATUS_ID")
})
public class MMemberDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "M_MEMBER_DETAILS", allocationSize = 1, sequenceName = "M_MEMBER_DETAILS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_MEMBER_DETAILS")
    @Column(name = "MEMBER_ID", nullable = false, length = 8)
    private Integer memberId;

    @Column(name = "MEMBER_CODE", nullable = false, length = 10)
    private String memberCode;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false)
    private RStatus rStatus;

}
