package model;
import java.util.*;

public abstract class Playlist{

  private String playlistTitle;
  private int playlistDuration;
  private Genre playlistGenre;
  private ArrayList<Song> playlistSongs;

  public Playlist(String playlistTitle){
    this.playlistTitle = playlistTitle;
    playlistDuration = 0;
    playlistGenre = Genre.UNKNOWN;
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
