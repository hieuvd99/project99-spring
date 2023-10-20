package com.example.repository;

public class BaseSQL {
  public static final String S0001 = "SELECT user_info.id, user_info.username, user_info.email, user_info.role, address.country, address.city FROM user_info INNER JOIN address ON user_info.id = address.user_id AND user_info.id = :id";
  public static final String S0002 = "SELECT * FROM address WHERE address.user_id = :user_id";


}
