package com.mkyong;

import com.mkyong.dao.BaseballCardRepository;
import com.mkyong.dao.CardUserRepository;
import com.mkyong.model.BaseballCard;
import com.mkyong.model.CardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WildflySpringBootApplication implements CommandLineRunner {
    @Autowired private BaseballCardRepository baseballCardRepository;
    @Autowired private CardUserRepository cardUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(WildflySpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CardUser user1 = new CardUser();
        user1.setEmail("alkim@suprema.co.kr");
        user1.setPhone("01099998888");
        cardUserRepository.save(user1);

        BaseballCard card = new BaseballCard();
        card.setName("baseball111");
        card.setRarityLevel("rare");
        card.setYear(1999);
        card.setCardUser(user1);
        baseballCardRepository.save(card);

        card = new BaseballCard();
        card.setName("baseball222");
        card.setRarityLevel("normal");
        card.setYear(1998);
        card.setCardUser(user1);
        baseballCardRepository.save(card);

        card = new BaseballCard();
        card.setName("baseball333");
        card.setRarityLevel("normal");
        card.setYear(2000);
        card.setCardUser(user1);
        baseballCardRepository.save(card);

        card = new BaseballCard();
        card.setName("baseball444");
        card.setRarityLevel("rare");
        card.setYear(2001);
        card.setCardUser(user1);
        baseballCardRepository.save(card);

// ----------------------- user1 --------------------------

        CardUser user2 = new CardUser();
        user2.setEmail("djin@suprema.co.kr");
        user2.setPhone("01099998888");
        cardUserRepository.save(user2);

        card = new BaseballCard();
        card.setName("baseball555");
        card.setRarityLevel("rare");
        card.setYear(1900);
        card.setCardUser(user2);
        baseballCardRepository.save(card);

        card = new BaseballCard();
        card.setName("baseball666");
        card.setRarityLevel("normal");
        card.setYear(1998);
        card.setCardUser(user2);
        baseballCardRepository.save(card);


// ----------------------------------------------------------
/*
        BaseballCard b1 = new BaseballCard();
        b1.setName("baseball111");
        b1.setRarityLevel("rare");
        b1.setYear(1999);
        baseballCardRepository.save(b1);

        CardUser user1 = new CardUser();
        user1.setEmail("alkim1@suprema.co.kr");
        user1.setPhone("01099998888");
        user1.setCard(b1);
        cardUserRepository.save(user1);

        CardUser user2 = new CardUser();
        user2.setEmail("alkim2@suprema.co.kr");
        user2.setPhone("01077776666");
        user2.setCard(b1);
        cardUserRepository.save(user2);

// ------------------------ baseball 2 -------------------------

        BaseballCard b2 = new BaseballCard();
        b2.setName("baseball222");
        b2.setRarityLevel("normal");
        b2.setYear(1990);
        baseballCardRepository.save(b2);

        CardUser user3 = new CardUser();
        user3.setEmail("alkim3@suprema.co.kr");
        user3.setPhone("01099998888");
        user3.setCard(b2);
        cardUserRepository.save(user3);

        CardUser user4 = new CardUser();
        user4.setEmail("alkim4@suprema.co.kr");
        user4.setPhone("01077776666");
        user4.setCard(b2);
        cardUserRepository.save(user4);
*/
    }
}
