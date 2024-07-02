package com.redowl.multipledbconfig.newSYS.services.impl;

import com.redowl.multipledbconfig.common.dto.ApiResponseDto;
import com.redowl.multipledbconfig.common.dto.PaginationDto;
import com.redowl.multipledbconfig.common.exception.BadRequestAlertException;
import com.redowl.multipledbconfig.common.search.FilterCriteria;
import com.redowl.multipledbconfig.common.search.FilterUtility;
import com.redowl.multipledbconfig.newSYS.dao.MMemberDetailsDao;
import com.redowl.multipledbconfig.newSYS.dto.request.MMemberDetailsReqDto;
import com.redowl.multipledbconfig.newSYS.dto.response.MMemberDetailsResDto;
import com.redowl.multipledbconfig.newSYS.mappers.MMemberDetailsMapper;
import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import com.redowl.multipledbconfig.newSYS.services.MMemberDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@Slf4j
@Service
public class MMemberDetailsServiceImpl implements MMemberDetailsService {
//    private final FilterUtility<MMemberDetails> filterUtility;
    private final MMemberDetailsDao memberDetailsDao;
    private final MMemberDetailsMapper memberDetailsMapper;

    public MMemberDetailsServiceImpl(MMemberDetailsDao memberDetailsDao, MMemberDetailsMapper memberDetailsMapper) {
//        this.filterUtility = new FilterUtility<>(memberDetailsDao);
        this.memberDetailsDao = memberDetailsDao;
        this.memberDetailsMapper = memberDetailsMapper;
    }

    @Override
    public ResponseEntity<ApiResponseDto<List<MMemberDetailsResDto>>> getAllMemberDetails(Integer page, Integer perPage, String sort, String direction, String search, Integer memberId, String status) {
        log.info("Inside MemberDetailsService: getAllMemberDetails method");
        try {

//            List<FilterCriteria<MMemberDetails>> filterCriteriaList = new ArrayList<>();
//
//            // set search
//            if (search != null && !search.isEmpty()) {
//                filterCriteriaList.add((root1, criteriaBuilder) ->
//                        (root, query, cb) -> cb.like(
//                                cb.lower(root.get("memberId").as(String.class)),
//                                "%" + search.toLowerCase() + "%"
//                        )
//                );
//            }
//
//            // set filters
//            if (memberId != null && memberId != 0) {
//                filterCriteriaList.add((root1, criteriaBuilder) ->
//                        (root, query, cb) -> cb.equal(root.get("memberId"), memberId)
//                );
//            }
//
//            if (status != null && status != "" && !status.isEmpty()) {
//                filterCriteriaList.add((root1, criteriaBuilder) ->
//                        (root, query, cb) -> cb.equal(root.get("rStatus").get("statusCode"), status)
//                );
//            }
//
//            // pageable
//            Page<MMemberDetails> pageableData = filterUtility.filterRecords(page, perPage, sort, direction, filterCriteriaList);
//
//            List<MMemberDetailsResDto> content = memberDetailsMapper.listToDto(pageableData.getContent());
//
//            // response
//            ApiResponseDto<List<MMemberDetailsResDto>> response = new ApiResponseDto<>();
//            PaginationDto paginationDto = new PaginationDto();
//            paginationDto.setTotal((int) pageableData.getTotalElements());
//            response.setPagination(paginationDto);
//            response.setResult(content);
//
//            return new ResponseEntity<>(response, HttpStatus.OK);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }

    @Override
    public ResponseEntity<MMemberDetailsResDto> getMemberDetailsById(Long id) {
        log.info("Inside MemberDetailsService: getMemberDetailsById method");
        try {
            Optional<MMemberDetails> memberDetails = memberDetailsDao.findByMemberIdAndIsActive(id, true);
            if (memberDetails.isPresent()) {
                return new ResponseEntity<>(memberDetailsMapper.toDto(memberDetails.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }

    @Override
    public ResponseEntity<MMemberDetailsResDto> addMemberDetails(MMemberDetailsReqDto memberDetailsReqDto) {
        log.info("Inside MemberDetailsService: addMemberDetails method");
        try {
            memberDetailsReqDto.setMemberId(null);
            if (memberDetailsReqDto.getMemberCode() == null || memberDetailsReqDto.getMemberCode().isEmpty())
                throw new BadRequestAlertException("Member code cannot be empty", ENTITY_NAME, "error");

            if (memberDetailsReqDto.getFirstName() == null || memberDetailsReqDto.getFirstName().isEmpty())
                throw new BadRequestAlertException("Member name cannot be empty", ENTITY_NAME, "error");

            memberDetailsReqDto.setIsActive(true);
            memberDetailsReqDto.setStatusId(1);

            MMemberDetails memberDetails = memberDetailsMapper.toEntity(memberDetailsReqDto);
            memberDetails = memberDetailsDao.save(memberDetails);
            return new ResponseEntity<>(memberDetailsMapper.toDto(memberDetails), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }
}
