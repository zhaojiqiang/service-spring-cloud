package com.zjq.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zjq.cloud.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
