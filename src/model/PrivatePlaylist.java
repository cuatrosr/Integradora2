package model;

public class PrivatePlaylist extends Playlist{

  private User privateAdmin;

  public PrivatePlaylist(String playlistTitle, User privateAdmin){
    super(playlistTitle);
    this.privateAdmin = privateAdmin;
  }

  public User getPrivateAdmin(){
    return privateAdmin;
  }

  public void setPrivateAdmin(User privateAdmin){
    this.privateAdmin = privateAdmin;
  }

  /**
  * Do nothing.
  * <b> pre: </b> Do nothing. <br>
  * <b> post: </b> Do nothing.
  */
  @Override
  public double convertPunctuation(){
    double nada = 0;
    return nada;
  }
}
