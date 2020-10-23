package model;

public class User{

  private String userName;
  private String userPassword;
  private int userAge;
  private String category;

  public User(String userName, String userPassword, int userAge){
    this.userName = userName;
    this.userPassword = userPassword;
    this.userAge = userAge;
    category = "NEWBIE";
  }

}
