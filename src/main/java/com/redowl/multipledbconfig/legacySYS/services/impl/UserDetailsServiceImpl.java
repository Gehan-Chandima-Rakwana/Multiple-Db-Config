package com.redowl.multipledbconfig.legacySYS.services.impl;

import com.redowl.multipledbconfig.common.exception.BadRequestAlertException;
import com.redowl.multipledbconfig.legacySYS.dao.UserDetailsDao;
import com.redowl.multipledbconfig.legacySYS.dto.request.UserDetailsReqDto;
import com.redowl.multipledbconfig.legacySYS.dto.response.UserDetailsResDto;
import com.redowl.multipledbconfig.legacySYS.mappers.UserDetailsMapper;
import com.redowl.multipledbconfig.legacySYS.models.UserDetails;
import com.redowl.multipledbconfig.legacySYS.services.UserDetailsService;
import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsDao userDetailsDao;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl(UserDetailsDao userDetailsDao, UserDetailsMapper userDetailsMapper) {
        this.userDetailsDao = userDetailsDao;
        this.userDetailsMapper = userDetailsMapper;
    }


    @Override
    public ResponseEntity<UserDetailsResDto> getUserDetailsById(Long id) {
        log.info("Inside UserDetailsService: getUserDetailsById method");
        try {
            Optional<UserDetails> userDetailsOp = userDetailsDao.findByUserIdAndIsActive(id, true);
            if (userDetailsOp.isPresent()) {
                return new ResponseEntity<>(userDetailsMapper.toDto(userDetailsOp.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }

    @Override
    public ResponseEntity<UserDetailsResDto> addUserDetails(UserDetailsReqDto userDetailsReqDto) {
        log.info("Inside UserDetailsService: addUserDetails method");
        try {
            userDetailsReqDto.setUserId(null);
            if (userDetailsReqDto.getUserCode() == null || userDetailsReqDto.getUserCode().isEmpty())
                throw new BadRequestAlertException("User code cannot be empty", ENTITY_NAME, "error");

            if (userDetailsReqDto.getFirstName() == null || userDetailsReqDto.getFirstName().isEmpty())
                throw new BadRequestAlertException("User name cannot be empty", ENTITY_NAME, "error");

            userDetailsReqDto.setIsActive(true);

            UserDetails userDetails = userDetailsMapper.toEntity(userDetailsReqDto);
            userDetails = userDetailsDao.save(userDetails);
            return new ResponseEntity<>(userDetailsMapper.toDto(userDetails), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }
}
