package model;

public class RestringedPlaylist extends Playlist{

  private User[] restringedAdmins = new User[MAX_RESTRINGED_ADMINS];
  private final static int MAX_RESTRINGED_ADMINS = 5;

  /**
  * Create a restringed playlist.
  * <b> pre: </b> addPlaylist was initiated. <br>
  * <b> post: </b> create a restringed playlist.
  * @param restringedAdmins != null
  * @param songDuration
  * @param genres
  * @param adminsRestringed
  */
  public RestringedPlaylist(String playlistTitle, User[] adminsRestringed){
    super(playlistTitle);
    this.restringedAdmins = adminsRestringed;
  }

  /**
  * Return the playlist admins.
  * <b> pre: </b> restringedAdmins != null. <br>
  * <b> post: </b> Return the playlist admins.
  * @return restringedAdmins
  */
  public User[] getRestringedAdmins(){
    return restringedAdmins;
  }

  /**
  * Set the playlist admins.
  * <b> pre: </b> restringedAdmins != null. <br>
  * <b> post: </b> set the playlist admins.
  * @param restringedAdmins != null
  */
  public void setRestringedAdmins(User[] restringedAdmins){
    this.restringedAdmins = restringedAdmins;
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
