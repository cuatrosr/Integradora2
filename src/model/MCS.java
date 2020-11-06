package model;
import java.util.*;

public class MCS{

  private final static int MAX_USERS = 10;
  private final static int MAX_SONGS_POOL = 30;
  private final static int MAX_PLAYLISTS = 20;
  private User[] users = new User[MAX_USERS];
  private Song[] pool = new Song[MAX_SONGS_POOL];
  private Playlist[] playlists = new Playlist[MAX_PLAYLISTS];
  private ArrayList<Song> songs = new ArrayList<Song>();
  private int totalUsers = 0;
  private int totalSongsPool = 0;

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

  public boolean addSong(String songTitle, String songArtist, int songDuration, int genreChoice){
    return songs.add(new Song(songTitle, songArtist, songDuration, genreChoice));
  }

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

  public User[] getUsers(){
    return users;
  }

  public Song[] getPoolSongs(){
    return pool;
  }

  public ArrayList<Song> getSongs(){
    return songs;
  }

  public int getTotalUsers(){
    return totalUsers;
  }

  public int getTotalSongsPool(){
    return totalSongsPool;
  }

  public Playlist[] getPlaylists(){
    return playlists;
  }
}
