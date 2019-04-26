package com.mkyong.dao;

import com.mkyong.model.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardUserRepository extends JpaRepository<CardUser, Long> {
}
