package com.redowl.multipledbconfig.legacySYS.mappers;

import com.redowl.multipledbconfig.legacySYS.dto.request.UserDetailsReqDto;
import com.redowl.multipledbconfig.legacySYS.dto.response.UserDetailsResDto;
import com.redowl.multipledbconfig.legacySYS.models.UserDetails;
import com.redowl.multipledbconfig.newSYS.dto.request.RStatusReqDto;
import com.redowl.multipledbconfig.newSYS.dto.response.RStatusResDto;
import com.redowl.multipledbconfig.newSYS.models.RStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetails toEntity(UserDetailsReqDto dto);

    UserDetailsResDto toDto(UserDetails entity);

    List<UserDetailsResDto> listToDto(List<UserDetails> entities);
}
