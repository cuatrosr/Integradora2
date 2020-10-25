package model;

public class User{

  private String userName;
  private String userPassword;
  private int userAge;
  private Category userCategory;

  public User(String userName, String userPassword, int userAge){
    this.userName = userName;
    this.userPassword = userPassword;
    this.userAge = userAge;
    userCategory = Category.NEWBIE;
  }

  public void setUserName(String userName){
    this.userName = userName;
  }

  public String getUserName(){
    return userName;
  }

  public void setUserPassword(String userPassword){
    this.userPassword = userPassword;
  }

  public String getUserPassword(){
    return userPassword;
  }

  public void setUserAge(int userAge){
    this.userAge = userAge;
  }

  public int getUserAge(){
    return userAge;
  }
}
