package model;
import java.util.*;

public class MCS{

  private final static int MAX_USERS = 10;
  private User[] users = new User[MAX_USERS];
  private ArrayList<Song> songs = new ArrayList<Song>();
  private int totalUsers = 0;

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

  public User[] getUsers(){
    return users;
  }

  public boolean addSong(String songTitle, String songArtist, int songDuration, int genreChoice){
    return songs.add(new Song(songTitle, songArtist, songDuration, genreChoice));
  }

  public ArrayList<Song> getSongs(){
    return songs;
  }
}
