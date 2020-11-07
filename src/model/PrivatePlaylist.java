package model;

public class PrivatePlaylist extends Playlist{

  private User privateAdmin;

  public PrivatePlaylist(String playlistTitle, int songDuration, Genre genres, User privateAdmin){
    super(playlistTitle, songDuration, genres);
    this.privateAdmin = privateAdmin;
  }

  public User getPrivateAdmin(){
    return privateAdmin;
  }

  public void setPrivateAdmin(User privateAdmin){
    this.privateAdmin = privateAdmin;
  }

  @Override
  public double convertPunctuation(){
    double nada = 0;
    return nada;
  }
}
