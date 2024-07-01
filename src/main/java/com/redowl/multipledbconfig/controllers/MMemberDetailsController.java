package com.redowl.multipledbconfig.controllers;

import com.redowl.multipledbconfig.common.dto.ApiResponseDto;
import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import com.redowl.multipledbconfig.newSYS.services.MMemberDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member-details")
public class MMemberDetailsController {

    private final MMemberDetailsService memberDetailsService;

    public MMemberDetailsController(MMemberDetailsService memberDetailsService) {
        this.memberDetailsService = memberDetailsService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDto<List<MMemberDetailsResDto>>> getAllMemberDetails(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer per_page,
            @RequestParam(defaultValue = "", required = false) String search,
            @RequestParam(defaultValue = "memberId", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String direction,
            @RequestParam(defaultValue = "", required = false) Integer memberId,
            @RequestParam(defaultValue = "", required = false) String status
    ) {
        log.info("Inside MemberDetailsController: getAllMemberDetails method");
        return memberDetailsService.getAllMemberDetails(page, per_page, sort, direction, search, memberId, status);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<MMemberDetailsResDto> getMemberDetailsById(
            @PathVariable Long id
    ) {
        log.info("Inside MemberDetailsController: getMemberDetailsById method");
        return memberDetailsService.getMemberDetailsById(id);
    }
}
