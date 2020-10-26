package model;

public class Song{

  private String songTitle;
  private String songArtist;
  private int songDuration;
  private Genre genre;
  private Genre[] allGenres = Genre.values();

  public Song(String songTitle, String songArtist, int songDuration, int genreChoice){
    this.songTitle = songTitle;
    this.songArtist = songArtist;
    this.songDuration = songDuration;
    genre = allGenres[genreChoice];
  }

  public String getSongTitle(){
    return songTitle;
  }

  public String getSongArtist(){
    return songArtist;
  }

  public int getSongDuration(){
    return songDuration;
  }

  public static String convertSongDuration(int songDuration){
    String msg = "0";
    if ((songDuration / 60) < 10){
      msg = "0" + (songDuration / 60) + ":";
    } else {
      msg = (songDuration / 60) + ":";
    }
    if ((songDuration % 60) < 10){
      msg += "0" + (songDuration % 60);
    } else {
      msg += (songDuration % 60);
    }
    return msg;
  }

  public Genre getGenre(){
    return genre;
  }

  public static void printAllGenre(Genre[] allGenres){
    System.out.println("\nEstos son los generos registrados, ingrese el cual su cancion pertenece: \n");
    for (int i = 0; i < allGenres.length; i++){
      System.out.println("(" + (i+1) + ("): ") + allGenres[i]);
    }
    System.out.println("");
  }
}
