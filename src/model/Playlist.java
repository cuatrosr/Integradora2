package model;
import java.util.*;

public abstract class Playlist{

  private String playlistTitle;
  private int playlistDuration;
  private Genre playlistGenre;
  private ArrayList<Song> playlistSongs;

  /**
  * Create a playlist.
  * <b> pre: </b> addPlaylist was initiated. <br>
  * <b> post: </b> Create a playlist.
  * @param playlistGenre
  */
  public Playlist(String playlistTitle){
    this.playlistTitle = playlistTitle;
    playlistDuration = 0;
    playlistGenre = Genre.UNKNOWN;
    playlistSongs = new ArrayList<Song>();
  }

  /**
  * Return the playlist title.
  * <b> pre: </b> playlist != null. <br>
  * <b> post: </b> Return the playlist title.
  * @return playlistTitle
  */
  public String getPlaylistTitle(){
    return playlistTitle;
  }

  /**
  * Return the playlist duration.
  * <b> pre: </b> playlist != null. <br>
  * <b> post: </b> Return the playlist duration.
  * @return playlistDuration
  */
  public int getPlaylistDuration(){
    return playlistDuration;
  }

  /**
  * Return the playlist genre.
  * <b> pre: </b> playlist != null. <br>
  * <b> post: </b> Return the playlist genre.
  * @return playlistGenre
  */
  public Genre getPlayListGenre(){
    return playlistGenre;
  }

  public abstract double convertPunctuation();
}
