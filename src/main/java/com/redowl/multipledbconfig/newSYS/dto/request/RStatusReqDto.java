package com.redowl.multipledbconfig.newSYS.dto.request;

import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RStatusReqDto {
    private Integer statusId;
    private String statusCode;
    private String description;
    private Boolean isActive;
}
