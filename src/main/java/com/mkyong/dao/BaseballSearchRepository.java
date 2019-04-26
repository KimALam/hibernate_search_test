package com.mkyong.dao;

import com.mkyong.model.BaseballCard;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseballSearchRepository {
    List<BaseballCard> fuzzySearch(String kw1, String kw2, Pageable pageable);
}
