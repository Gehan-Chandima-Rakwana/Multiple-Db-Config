package com.redowl.multipledbconfig.legacySYS.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsReqDto {
    private Integer userId;
    private String userCode;
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
}
