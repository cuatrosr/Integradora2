package model;

public class User{

  private String userName;
  private String userPassword;
  private int userAge;
  private int shareSong;
  private Category userCategory;

  public User(String userName, String userPassword, int userAge){
    this.userName = userName;
    this.userPassword = userPassword;
    this.userAge = userAge;
    shareSong = 0;
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

  public int getShareSong(){
    return shareSong;
  }

  public void setShareSong(int shareSong){
    this.shareSong = shareSong;
  }

  public Category getUserCategory(){
    return userCategory;
  }

  public void setUserCategory(Category userCategory){
    this.userCategory = userCategory;
  }
}
