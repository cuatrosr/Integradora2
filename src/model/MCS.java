package model;
import java.util.*;

public class MCS{

  private final static int MAX_USERS = 10;
  private final static int MAX_SONGS_POOL = 30;
  private final static int MAX_PLAYLISTS = 20;
  private User[] users = new User[MAX_USERS];
  private Song[] pool = new Song[MAX_SONGS_POOL];
  private Playlist[] playlists = new Playlist[MAX_PLAYLISTS];
  private ArrayList<Double> publicPunctuation = new ArrayList<Double>();
  private ArrayList<Song> songs = new ArrayList<Song>();
  private int totalUsers = 0;
  private int totalSongsPool = 0;

  /**
  * Register a user.
  * <b> pre: </b> registerInfoUser initiated. <br>
  * <b> post: </b> Create a user.
  * @param userName songTitle != null.
  * @param userPassword userPassword != null.
  * @param userAge userAge != null
  */
  public boolean registerUser(String userName, String userPassword, int userAge){
    boolean added = false;
    for (int i = 0; i < MAX_USERS && !added; i++){
      if (users[i] == null){
        users[i] = new User(userName, userPassword, userAge);
        added = true;
        totalUsers++;
      }
    }
    return added;
  }

  /**
  * Check if a user is registered in the app.
  * <b> pre: </b> Login was initiated .users != null. <br>
  * <b> post: </b> Return true if the user is found in the app.
  * @param userName songTitle != null.
  * @param userPassword userPassword != null.
  * @param users users != null.
  */
  public boolean isUserRegistered(String userName, String userPassword, User[] users){
    boolean registered = false;
    try {
      for (int i = 0; i < MAX_USERS && !registered; i++){
        if ((users[i].getUserName().equals(userName)) && (users[i].getUserPassword().equals(userPassword))){
          registered = true;
        }
      }
    } catch (NullPointerException e){
    }
    return registered;
  }

  /**
  * set the active user after loged in.
  * <b> pre: </b> Login was initiated .users != null. <br>
  * <b> post: </b> Return the index of the user loged in.
  * @param userName songTitle != null.
  * @param users users != null.
  */
  public int isActiveUser(String userName, User[] users){
    int active = 0;
    boolean found = false;
    try {
      for (int i = 0; i < users.length; i++){
        if (users[i].getUserName().equals(userName) && !found){
          active = i;
          found = true;
        }
      }
    } catch (NullPointerException e){
    }
    return active;
  }

  /**
  * return a boolean if the song was added correctly
  * <b> pre: </b> addSong was initiated. <br>
  * <b> post: </b> Return true if the song was added correctly.
  * @param songTitle songTitle != null.
  * @param songArtist songArtist != null.
  * @param songDuration songDuration != null && songDuration must be on numeral.
  * @param genreChoice genreChoice != null.
  * @param activeUser get the user that is connected.
  */
  public boolean addSong(String songTitle, String songArtist, int songDuration, int genreChoice){
    return songs.add(new Song(songTitle, songArtist, songDuration, genreChoice));
  }

  /**
  * Share a song if the user want to.
  * <b> pre: </b> addSong was initiated. <br>
  * <b> post: </b> Share a song and added to the pool.
  * @param songTitle songTitle != null.
  * @param songArtist songArtist != null.
  * @param songDuration songDuration != null && songDuration must be on numeral.
  * @param genreChoice genreChoice != null.
  * @param activeUser get the user that is connected.
  */
  public boolean shareSong(String songTitle, String songArtist, int songDuration, int genreChoice, int activeUser){
    boolean added = false;
    for (int i = 0; i < MAX_SONGS_POOL && !added; i++){
      if (pool[i] == null){
        pool[i] = new Song(songTitle, songArtist, songDuration, genreChoice);
        added = true;
        int shareSong = users[activeUser].getShareSong();
        shareSong++;
        users[activeUser].setShareSong(shareSong);
        updateCategory(activeUser);
        totalSongsPool++;
      }
    }
    return added;
  }

  /**
  * Update the category of the user.
  * <b> pre: </b> shareSong was initiated. <br>
  * <b> post: </b> Update the category of a user after share a song on pool.
  * @param activeUser get the user that is connected.
  */
  public void updateCategory(int activeUser){
    Category userCategory;
    switch (users[activeUser].getShareSong()){
      case 3:
        userCategory = Category.LITTLECONTRIBUTOR;
        users[activeUser].setUserCategory(userCategory);
        break;
      case 10:
        userCategory = Category.MILDCONTRIBUTOR;
        users[activeUser].setUserCategory(userCategory);
        break;
      case 30:
        userCategory = Category.STARCONTRIBUTOR;
        users[activeUser].setUserCategory(userCategory);
        break;
      default:
    }
  }

  /**
  * Return the users of the app.
  * <b> pre: </b> adminPartProgram was initiated. <br>
  * <b> post: </b> Return information of users in app.
  * @return users
  */
  public User[] getUsers(){
    return users;
  }

  /**
  * Return the songs of the pool.
  * <b> pre: </b> adminPartProgram was initiated. <br>
  * <b> post: </b> Return the songs in pool.
  * @return pool
  */
  public Song[] getPoolSongs(){
    return pool;
  }

  /**
  * Return the songs of the app.
  * <b> pre: </b> adminPartProgram was initiated. <br>
  * <b> post: </b> Return total songs in app.
  * @return songs
  */
  public ArrayList<Song> getSongs(){
    return songs;
  }

  /**
  * Return the total users registered.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Return total songs in Pool.
  * @return totalSongsPool
  */
  public int getTotalUsers(){
    return totalUsers;
  }

  /**
  * Return the ammount of songs in pool.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Return total songs in Pool.
  * @return totalSongsPool
  */
  public int getTotalSongsPool(){
    return totalSongsPool;
  }

  /**
  * Add a restringed playlist.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Added a restringed playlist.
  * @return playlists
  */
  public Playlist[] getPlaylists(){
    return playlists;
  }

  /**
  * Return a boolean depending if the playlist is full or not.
  * <b> pre: </b> <br>
  * <b> post: </b> return true or false.
  * @return full
  */
  public boolean topPlaylist(){
    boolean full = false;
    int count = 0;
    for (int i = 0; i < MAX_PLAYLISTS; i++){
      if (playlists[i] != null){
        count++;
      }
    }
    if (count == MAX_PLAYLISTS){
      full = true;
    }
    return full;
  }

  /**
  * Add a private playlist.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Added a private playlist.
  * @param playlistTitle playlistTitle != null.
  * @param privateAdmin privateAdmin != null.
  * @return msg
  */
  public String addPlaylist(String playlistTitle, User privateAdmin){
    boolean added = false;
    String msg = "";
    boolean full = topPlaylist();
    if (full){
      msg = "\nNo se pueden agregar mas playlist.";
    } else {
      for (int i = 0; i < MAX_PLAYLISTS && !added; i++){
        if (playlists[i] == null){
          playlists[i] = new PrivatePlaylist(playlistTitle, privateAdmin);
          added = true;
          msg = "\nLa playlist se agrego exitosamente.";
        }
      }
    }
    return msg;
  }

  /**
  * Add a restringed playlist.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Added a restringed playlist.
  * @param playlistTitle playlistTitle != null.
  * @param adminsRestringed adminsRestringed != null.
  * @return msg
  */
  public String addPlaylist(String playlistTitle, User[] adminsRestringed){
    boolean added = false;
    String msg = "";
    boolean full = topPlaylist();
    if (full){
      msg = "\nNo se pueden agregar mas playlist.";
    } else {
      for (int i = 0; i < MAX_PLAYLISTS && !added; i++){
        if (playlists[i] == null){
          playlists[i] = new RestringedPlaylist(playlistTitle, adminsRestringed);
          added = true;
          msg = "\nLa playlist se agrego exitosamente.";
        }
      }
    }
    return msg;
  }

  /**
  * Add a public playlist.
  * <b> pre: </b> addPlaylist from menu was initiated. <br>
  * <b> post: </b> Added a public playlist.
  * @param playlistTitle playlistTitle != null.
  * @return msg
  */
  public String addPlaylist(String playlistTitle){
    boolean added = false;
    String msg = "";
    boolean full = topPlaylist();
    if (full){
      msg = "\nNo se pueden agregar mas playlist.";
    } else {
      for (int i = 0; i < MAX_PLAYLISTS && !added; i++){
        if (playlists[i] == null){
          playlists[i] = new PublicPlaylist(playlistTitle);
          added = true;
          msg = "\nLa playlist se agrego exitosamente.";
        }
      }
    }
    return msg;
  }

  /**
  * Print the punctuation.
  * <b> pre: </b> playlistPartProgram was initiated. <br>
  * <b> post: </b> print the punctuation.
  * @return msg
  */
  public String showPunctuation(){
    String msg = "\n**************  Playlists **************\n";
    boolean publicClassFound = false;
    for (int i = 0; i < playlists.length; i++){
      if (playlists[i] instanceof PublicPlaylist){
        publicClassFound = true;
      }
    }
    try {
      if (publicClassFound){
        for (int i = 0; i < playlists.length; i++){
          if (playlists[i] instanceof PublicPlaylist){
            msg += "\n***********************************";
            msg += "\n**  Title: " + playlists[i].getPlaylistTitle();
            msg += "\n**  Punctuation: " + playlists[i].convertPunctuation();
            msg += "\n***********************************\n";
          }
        }
      } else {
        msg += "\n**  No hay Playlists Publicas.";
        msg += "\n***********************************";
      }
    } catch (NullPointerException e) {
    }
    return msg;
  }

  /**
  * Return a boolean if the punctuation was added to the ArrayList.
  * <b> pre: </b> prueba1 != null. <br>
  * <b> post: </b> return true if the punctuation was added correctly.
  * @param prueba1 prueba1 != null.
  * @return punctuation
  */
  public boolean punctuationPlaylist(double prueba1){
    boolean punctuation = false;
    if (publicPunctuation.add(prueba1)) {
      punctuation = true;
    }
    return punctuation;
  }

  /**
  * Return the ArrayList publicPunctuation.
  * <b> pre: </b> ArrayList<Double> was initiated. <br>
  * <b> post: </b> Return the ArrayList publicPunctuation.
  * @return publicPunctuation
  */
  public ArrayList<Double> getPublicPunctuation(){
    return publicPunctuation;
  }
}
