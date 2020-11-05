package model;

public abstract class Playlist{

  private String playlistTitle;
  private int playlistDuration;
  private Genre playlistGenre;

  public Playlist(String playlistTitle, int songDuration, Genre genres){
    this.playlistTitle = playlistTitle;
    playlistDuration = 0;
    playlistGenre = genres;
  }

  public String getPlaylistTitle(){
    return playlistTitle;
  }

  public int getPlaylistDuration(){
    return playlistDuration;
  }

  public Genre getPlayListGenre(){
    return playlistGenre;
  }

  public String showPlaylist(){
    String msg = "\n**************  Playlist **************";
    msg += "\n**  Title: " + getPlaylistTitle();
    msg += "\n**  Duration: " + getPlaylistDuration();
    msg += "\n**  Genre: " + getPlaylistGenre();
    return msg;
  }
}
