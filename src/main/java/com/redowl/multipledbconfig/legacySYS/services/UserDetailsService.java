package com.redowl.multipledbconfig.legacySYS.services;

import com.redowl.multipledbconfig.legacySYS.dto.request.UserDetailsReqDto;
import com.redowl.multipledbconfig.legacySYS.dto.response.UserDetailsResDto;
import org.springframework.http.ResponseEntity;

public interface UserDetailsService {
    ResponseEntity<UserDetailsResDto> getUserDetailsById(Long id);

    ResponseEntity<UserDetailsResDto> addUserDetails(UserDetailsReqDto userDetailsReqDto);
}
