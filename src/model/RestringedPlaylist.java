import model;

public class RestringedPlaylist extends Playlist{

  private User[] restringedAdmins;
  private final static int MAX_RESTRINGED_ADMINS;

  public RestringedPlaylist(String playlistTitle, int songDuration, Genre genres){
    super(playlistTitle, songDuration, genres);
    restringedAdmins = new User[MAX_RESTRINGED_ADMINS];
  }

  public User[] getRestringedAdmins(){
    return restringedAdmins;
  }

  public void setRestringedAdmins(User[] restringedAdmins){
    this.restringedAdmins = restringedAdmins;
  }
}
