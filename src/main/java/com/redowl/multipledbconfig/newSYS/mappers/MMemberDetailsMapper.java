package com.redowl.multipledbconfig.newSYS.mappers;

import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface MMemberDetailsMapper {
    @Mappings({
            @Mapping(target = "statusId", source = "rStatus.statusId")
    })
    MMemberDetailsResDto toDto(MMemberDetails entity);

    @Mappings({
            @Mapping(source = "statusId", target = "rStatus.statusId")
    })
    MMemberDetails toEntity(MMemberDetailsResDto dto);

    @Mappings({
            @Mapping(target = "statusId", source = "rStatus.statusId")
    })
    List<MMemberDetailsResDto> listToDto(List<MMemberDetails> entities);
}
