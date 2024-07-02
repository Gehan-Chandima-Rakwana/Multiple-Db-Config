package com.redowl.multipledbconfig.controllers;

import com.redowl.multipledbconfig.legacySYS.dto.request.UserDetailsReqDto;
import com.redowl.multipledbconfig.legacySYS.dto.response.UserDetailsResDto;
import com.redowl.multipledbconfig.legacySYS.services.UserDetailsService;
import com.redowl.multipledbconfig.newSYS.dto.request.MMemberDetailsReqDto;
import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user-details")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDetailsResDto> getUserDetailsById(
            @PathVariable Long id
    ) {
        log.info("Inside UserDetailsController: getUserDetailsById method");
        return userDetailsService.getUserDetailsById(id);
    }


    @PostMapping("/add")
    public ResponseEntity<UserDetailsResDto> addUserDetails(@RequestBody UserDetailsReqDto userDetailsReqDto) {
        log.info("Inside UserDetailsController: addUserDetails method");
        return userDetailsService.addUserDetails(userDetailsReqDto);
    }
}
