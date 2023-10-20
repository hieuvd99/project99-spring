package com.example.model;

import jakarta.persistence.*;

@Entity
@Table( name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long address_id;

  private String country;

  private String city;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  public Address() {
  }

  public Address(String country, String city, User user) {
    this.country = country;
    this.city = city;
    this.user = user;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
