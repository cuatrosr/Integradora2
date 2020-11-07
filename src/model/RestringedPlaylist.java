package model;

public class RestringedPlaylist extends Playlist{

  private User[] restringedAdmins = new User[MAX_RESTRINGED_ADMINS];
  private final static int MAX_RESTRINGED_ADMINS = 5;

  public RestringedPlaylist(String playlistTitle, int songDuration, Genre genres, User[] adminsRestringed){
    super(playlistTitle, songDuration, genres);
    this.restringedAdmins = adminsRestringed;
  }

  public User[] getRestringedAdmins(){
    return restringedAdmins;
  }

  public void setRestringedAdmins(User[] restringedAdmins){
    this.restringedAdmins = restringedAdmins;
  }

  @Override
  public double convertPunctuation(){
    double nada = 0;
    return nada;
  }
}
