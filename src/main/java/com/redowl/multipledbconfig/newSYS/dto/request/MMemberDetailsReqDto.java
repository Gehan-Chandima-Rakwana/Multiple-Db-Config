package com.redowl.multipledbconfig.newSYS.dto.request;

import com.redowl.multipledbconfig.newSYS.models.RStatus;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MMemberDetailsReqDto {
    private Integer memberId;
    private String memberCode;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoin;
    private String nameWithInitials;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String identityNo;
    private Boolean isActive;
    private String email;

    private Integer statusId;
}
