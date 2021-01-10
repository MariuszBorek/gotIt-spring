package com.gotit.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String houseNumber;
    private String postcode;
    private String province;
    private String city;
    @OneToMany(mappedBy = "address")
    private List<UserAccount> userAccount;

    public Address() {
    }

    public Address(String street, String houseNumber, String postcode, String province, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.province = province;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(street, address.street) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(province, address.province) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, houseNumber, postcode, province, city);
    }
}
