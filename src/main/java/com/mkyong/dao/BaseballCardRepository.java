package com.mkyong.dao;

import com.mkyong.model.BaseballCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseballCardRepository extends JpaRepository<BaseballCard,Long>, BaseballSearchRepository {

}
