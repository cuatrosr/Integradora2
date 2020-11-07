package model;

public class User{

  private String userName;
  private String userPassword;
  private int userAge;
  private int shareSong;
  private Category userCategory;

  /**
  * Create a user.
  * <b> pre: </b> registerInfoUser initiated. <br>
  * <b> post: </b> Create a user.
  * @param userName userName != null
  * @param userPassword userPassword != null
  * @param userAge userAge != null
  */
  public User(String userName, String userPassword, int userAge){
    this.userName = userName;
    this.userPassword = userPassword;
    this.userAge = userAge;
    shareSong = 0;
    userCategory = Category.NEWBIE;
  }

  /**
  * Set the user name.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Set the user name.
  * @param userName userName != null
  */
  public void setUserName(String userName){
    this.userName = userName;
  }

  /**
  * Return the user Category.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Return the user category.
  * @return userCategory
  */
  public String getUserName(){
    return userName;
  }

  /**
  * Set the user password.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Set the user password.
  * @param userPassword userPassword != null
  */
  public void setUserPassword(String userPassword){
    this.userPassword = userPassword;
  }

  /**
  * Return the user password.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Return the user Password.
  * @return userPassword
  */
  public String getUserPassword(){
    return userPassword;
  }

  /**
  * Set the user age.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Set the user age.
  * @param setUserAge setUserAge != null
  */
  public void setUserAge(int userAge){
    this.userAge = userAge;
  }

  /**
  * Return the user Age.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Return the user Age.
  * @return userAge
  */
  public int getUserAge(){
    return userAge;
  }

  /**
  * Return the user song share.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Return the ammount of songs shared.
  * @return shareSong
  */
  public int getShareSong(){
    return shareSong;
  }

  /**
  * Set the ammount of shared songs by user.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Set the ammount of songs shared.
  * @param shareSong shareSong != null
  */
  public void setShareSong(int shareSong){
    this.shareSong = shareSong;
  }

  /**
  * Return the user Category.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Return the user category.
  * @return userCategory
  */
  public Category getUserCategory(){
    return userCategory;
  }

  /**
  * Set the user Category.
  * <b> pre: </b> User != null. <br>
  * <b> post: </b> Set the user category.
  * @param userCategory userCategory != null
  */
  public void setUserCategory(Category userCategory){
    this.userCategory = userCategory;
  }
}
