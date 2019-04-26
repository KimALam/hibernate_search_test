package com.mkyong.controller;

import com.mkyong.dao.BaseballSearchRepository;
import com.mkyong.model.BaseballCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class CardController {
    @Autowired
    private BaseballSearchRepository baseballSearchRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<BaseballCard>> search(@RequestParam(value = "q1") String q1,
                                                     @RequestParam(value = "q2") String q2,
                                                     Pageable page) {
        System.out.println("q1=" + q1);
        System.out.println("q2=" + q2);
/*        System.out.println("pageable=" + page);
        System.out.println("getSort=" + page.getSort());
        Iterator<Sort.Order> orders = page.getSort().iterator();
        while (orders.hasNext()) {
            Sort.Order o = orders.next();
            System.out.println("@@ " + o.getProperty());
            System.out.println("@@ " + o.getDirection());
        }*/


        List<BaseballCard> searchResults = null;
        try {
            searchResults = baseballSearchRepository.fuzzySearch(q1, q2, page);
        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
            System.out.println("error: " + ex.getMessage());
        }

        return ResponseEntity.ok(searchResults);
    }

}
