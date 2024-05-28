package com.redowl.multipledbconfig.newSYS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RStatusResDto {
    private Integer statusId;
    private String statusCode;
    private String description;
    private Boolean isActive;
}
