package com.gotit.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String avatar;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Auction> auction;

    public Category() {
    }

    public Category(String name, String description, String avatar) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, avatar);
    }


}
