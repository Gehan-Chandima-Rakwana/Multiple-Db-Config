package com.redowl.multipledbconfig.newSYS.mappers;

import com.redowl.multipledbconfig.newSYS.dto.request.RStatusReqDto;
import com.redowl.multipledbconfig.newSYS.dto.response.RStatusResDto;
import com.redowl.multipledbconfig.newSYS.models.RStatus;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface RStatusMapper {
    RStatus toEntity(RStatusReqDto dto);

    RStatusResDto toDto(RStatus entity);

    List<RStatusResDto> listToDto(List<RStatus> entities);
}
