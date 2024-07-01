package com.redowl.multipledbconfig.newSYS.dao;

import com.redowl.multipledbconfig.newSYS.models.RStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RStatusDao extends JpaRepository<RStatus, Integer> {
}
