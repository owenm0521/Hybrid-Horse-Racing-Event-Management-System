package com.morris.hybridhorseracingeventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.morris.hybridhorseracingeventmanagement.model.GeneralUser;

/*
 * General User Repository
 */
@Transactional
public interface GeneralUserRepository extends UserBaseRepository<GeneralUser> { }
