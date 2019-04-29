package com.mkyong.dao;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.hibernate.search.annotations.Factory;

public class UserIdFilterFactory {
    private Long userId;

    public void setUserId(Long userId) {
        System.out.println("UserIdFilterFactory.setUserId: " + userId);
        this.userId = userId;
    }

    @Factory
    public Query getFilter() {
//        return new TermQuery(new Term("user_id", userId.toString()));
        return new TermQuery(new Term("cardUser.id", userId.toString()));
    }

/*    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Key
    public FilterKey getKey() {
        StandardFilterKey key = new StandardFilterKey();
        key.addParameter(userId);
        return key;
    }

    @Factory
    public Filter getFilter() {
        Query query = (Query) new TermQuery(new Term("user_id", userId+"".toString()));
        return new CachingWrapperFilter(new QueryWrapperFilter((org.apache.lucene.search.Query) query));
    }*/
}
