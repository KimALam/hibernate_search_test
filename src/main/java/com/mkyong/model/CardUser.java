package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CardUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

//    @Field
//    @Analyzer(definition = "emailanalyzer")
    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "cardUser")
    private List<BaseballCard> cards = new ArrayList<>();
    public List<BaseballCard> getCards() { return cards; }
    public void setCards(BaseballCard card) { this.cards.add(card); }
//    @ManyToOne
//    @JoinColumn(name = "card_id")
//    private BaseballCard card;
//    public BaseballCard getCard() { return card; }
//    public void setCard(BaseballCard card) { this.card = card; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "CardUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
