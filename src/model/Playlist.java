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

  public int getPlayListDuration(){
    return playlistDuration;
  }

  public Genre getPlayListGenre(){
    return playlistGenre;
  }

  public void showPlaylist(){
    System.out.println("**************  Playlist **************");
    System.out.println("**  Title: Musica para programar");
    System.out.println("**  Duration: 11:48");
    System.out.println("**  Genre: ROCK, HIPHOP");
  }
}
