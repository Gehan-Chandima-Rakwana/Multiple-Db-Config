package com.redowl.multipledbconfig.newSYS.services;

import com.redowl.multipledbconfig.common.dto.ApiResponseDto;
import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MMemberDetailsService {
    ResponseEntity<ApiResponseDto<List<MMemberDetailsResDto>>> getAllMemberDetails(Integer page, Integer perPage, String sort, String direction, String search, Integer memberId, String status);

    ResponseEntity<MMemberDetailsResDto> getMemberDetailsById(Long id);
}
