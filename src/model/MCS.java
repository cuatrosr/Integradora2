package model;
import java.util.*;

public class MCS{

  private final static int MAX_USERS = 10;
  private final static int MAX_SONGS_POOL = 30;
  private User[] users = new User[MAX_USERS];
  private Song[] pool = new Song[MAX_SONGS_POOL];
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

  public boolean addSong(String songTitle, String songArtist, int songDuration, int genreChoice){
    return songs.add(new Song(songTitle, songArtist, songDuration, genreChoice));
  }

  public boolean shareSong(String songTitle, String songArtist, int songDuration, int genreChoice){
    boolean added = false;
    for (int i = 0; i < MAX_SONGS_POOL && !added; i++){
      if (pool[i] == null){
        pool[i] = new Song(songTitle, songArtist, songDuration, genreChoice);
        added = true;
        totalSongsPool++;
      }
    }
    return added;
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
}
