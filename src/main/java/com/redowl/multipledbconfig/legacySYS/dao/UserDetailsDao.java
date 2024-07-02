package com.redowl.multipledbconfig.legacySYS.dao;

import com.redowl.multipledbconfig.legacySYS.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUserIdAndIsActive(Long id, boolean b);
}
