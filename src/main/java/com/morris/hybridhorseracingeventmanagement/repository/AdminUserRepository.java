package com.morris.hybridhorseracingeventmanagement.repository;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.transaction.annotation.Transactional;

import com.morris.hybridhorseracingeventmanagement.model.AdminUser;

/*
 * Admin User Repository
 */
@Transactional
public interface AdminUserRepository extends UserBaseRepository<AdminUser>{ }
