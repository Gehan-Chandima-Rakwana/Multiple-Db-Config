package com.redowl.multipledbconfig.legacySYS.dao;

import com.redowl.multipledbconfig.legacySYS.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {
}
