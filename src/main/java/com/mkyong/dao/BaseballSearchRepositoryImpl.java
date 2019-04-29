package com.mkyong.dao;

import com.mkyong.model.BaseballCard;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Component(value = "baseballSearchRepository")
public class BaseballSearchRepositoryImpl implements BaseballSearchRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void initializeHibernateSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<BaseballCard> fuzzySearch(String q1, String q2, Pageable pageable) {
        initializeHibernateSearch();

        System.out.println("fuzzySearch| q1: " + q1 + ", q2: " + q2);

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(BaseballCard.class)
                .get();

        // Lucene query
        Query luceneQuery = qb.keyword()
                .wildcard()
//                .fuzzy()
//                .withEditDistanceUpTo(1)
//                .withPrefixLength(1)
//                .onFields("name", "rarityLevel", "cardUser.email")
//                .onFields("name", "rarityLevel", "cardUser.email")
                .onFields("name")
                .matching(q2)
                .createQuery();

/*        Query subq1 = qb.keyword()
                .wildcard()
                .onFields("name")
                .matching(q2)
                .createQuery();

        Query subq2 = qb.keyword()
                .onFields("userId")
                .matching(Long.parseLong(q1))
                .createQuery();

        Query luceneQuery = qb.bool()
                .must(subq1)
                .must(subq2)
                .createQuery();*/

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, BaseballCard.class);
        // filter
        fullTextQuery.enableFullTextFilter("BaseballFilterByUserId").setParameter("userId", Long.parseLong(q1));
//        jpaQuery.setFirstResult(pageable.getPageNumber());
//        jpaQuery.setMaxResults(pageable.getPageSize());

        // Sort
/*        org.apache.lucene.search.Sort sort = new org.apache.lucene.search.Sort();

        Iterator<Sort.Order> orders = pageable.getSort().iterator();
        Sort.Order o = orders.next();
        if (o.getDirection().equals(Sort.Direction.ASC)) {
            sort.setSort(new SortField(o.getProperty(), SortField.Type.STRING, false));
        } else {
            sort.setSort(new SortField(o.getProperty(), SortField.Type.STRING, true));
        }
        jpaQuery.setSort(sort);*/

        System.out.println("parameters: " + fullTextQuery.getParameters());
        // execute search
        List<BaseballCard> baseballCardList = fullTextQuery.getResultList();

        System.out.println("size: " + baseballCardList.size());
        for (BaseballCard card : baseballCardList) {
            System.out.println("card: " + card);
        }
        return baseballCardList;
    }
}
