package model;
import java.util.*;

public abstract class Playlist{

  private String playlistTitle;
  private int playlistDuration;
  private Genre playlistGenre;
  private ArrayList<Song> playlistSongs;

  public Playlist(String playlistTitle, int songDuration, Genre genres){
    this.playlistTitle = playlistTitle;
    playlistDuration = 0;
    playlistGenre = genres;
    playlistSongs = new ArrayList<Song>();
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

  public abstract double convertPunctuation();
}
