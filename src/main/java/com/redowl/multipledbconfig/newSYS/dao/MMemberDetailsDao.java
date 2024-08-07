package com.redowl.multipledbconfig.newSYS.dao;

import com.redowl.multipledbconfig.newSYS.models.MMemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MMemberDetailsDao extends JpaRepository<MMemberDetails, Integer>, JpaSpecificationExecutor<MMemberDetails> {
    Optional<MMemberDetails> findByMemberIdAndIsActive(Long id, boolean b);
}
