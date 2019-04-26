package com.mkyong.model;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.ClassicTokenizerFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Indexed
@AnalyzerDef(
        name = "emailanalyzer",
        tokenizer = @TokenizerDef(factory = ClassicTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class)
        }
)
public class BaseballCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    @SortableField
    private long id;

    @Field
    @SortableField
    @Column(name = "card_name")
    private String name;

    @Field
    @Column(name = "card_rarity")
    private String rarityLevel;

    @Field
    @Column(name = "card_year")
    private int year;

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CardUser cardUser;
    public CardUser getCardUser() { return cardUser; }
    public void setCardUser(CardUser cardUser) { this.cardUser = cardUser; }
//    @OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
//    private List<CardUser> users = new ArrayList<>();
//    public List<CardUser> getUsers() { return users; }
//    public void setUsers(List<CardUser> users) { this.users = users; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(String rarityLevel) {
        this.rarityLevel = rarityLevel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BaseballCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarityLevel='" + rarityLevel + '\'' +
                ", year=" + year +
                '}';
    }
}
