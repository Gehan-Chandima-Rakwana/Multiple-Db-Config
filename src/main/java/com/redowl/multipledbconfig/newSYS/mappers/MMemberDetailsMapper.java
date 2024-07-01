package com.redowl.multipledbconfig.newSYS.mappers;

import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = "spring")
public interface MMemberDetailsMapper {
    @Mappings({
            @Mapping(target = "statusId", source = "RStatus.statusId")
    })
    MMemberDetailsResDto toDto(MMemberDetails entity);

    @Mappings({
            @Mapping(source = "statusId", target = "RStatus.statusId")
    })
    MMemberDetails toEntity(MMemberDetailsResDto dto);

    @Mappings({
            @Mapping(target = "statusId", source = "RStatus.statusId")
    })
    List<MMemberDetailsResDto> listToDto(List<MMemberDetails> entities);
}
