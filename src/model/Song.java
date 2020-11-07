package model;

public class Song{

  private String songTitle;
  private String songArtist;
  private int songDuration;
  private Genre genre;
  private Genre[] allGenres = Genre.values();

  /**
  * Create a user.
  * <b> pre: </b> addInfoSong initiated. <br>
  * <b> post: </b> Create a song.
  * @param songTitle songTitle != null
  * @param songArtist songArtist != null
  * @param songDuration songDuration != null
  * @param genreChoice genreChoice != null
  */
  public Song(String songTitle, String songArtist, int songDuration, int genreChoice){
    this.songTitle = songTitle;
    this.songArtist = songArtist;
    this.songDuration = songDuration;
    genre = allGenres[genreChoice];
  }

  /**
  * Return the song title.
  * <b> pre: </b> Song != null. <br>
  * <b> post: </b> Return the song title.
  * @return songTitle
  */
  public String getSongTitle(){
    return songTitle;
  }

  /**
  * Return the author song.
  * <b> pre: </b> Song != null. <br>
  * <b> post: </b> Return the author song.
  * @return songArtist
  */
  public String getSongArtist(){
    return songArtist;
  }

  /**
  * Return the song duration.
  * <b> pre: </b> Song != null. <br>
  * <b> post: </b> Return the song duration.
  * @return songDuration
  */
  public int getSongDuration(){
    return songDuration;
  }

  /**
  * Method that take the seconds and give it a format Minutes-Seconds(xx:xx).
  * <b> pre: </b> <br>
  * <b> post: </b> Show the genres.
  * @param allGenres Get the genres of the Genre class.
  */
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

  /**
  * Return the genre song.
  * <b> pre: </b> Song != null. <br>
  * <b> post: </b> Return the genre song.
  * @return genre
  */
  public Genre getGenre(){
    return genre;
  }

  /**
  * Show all the genres of the class Genre.
  * <b> pre: </b> <br>
  * <b> post: </b> Show the genres.
  * @param allGenres Get the genres of the Genre class.
  */
  public static void printAllGenre(Genre[] allGenres){
    System.out.println("\nEstos son los generos registrados, ingrese el cual su cancion pertenece: \n");
    for (int i = 0; i < allGenres.length; i++){
      System.out.println("(" + (i+1) + ("): ") + allGenres[i]);
    }
    System.out.println("");
  }
}
