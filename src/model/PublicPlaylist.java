import model;
import java.util.*;

public class PublicPlaylist extends Playlist{

  private ArrayList<double> publicPunctuation;
  private int ammountPunctuation = 0;

  public PublicPlaylist(String playlistTitle, int songDuration, Genre genres){
    super(playlistTitle, songDuration, genres);
    publicPunctuation = new ArrayList<double>();
  }

  public ArrayList<int> getPublicPunctuation(){
    return publicPunctuation;
  }

  public String showPunctuation(){
    Playlist[] playlists = app.getPlaylists();
    String msg = "\n**************  Playlists **************\n";
    boolean public = false;
    for (int i = 0; i < playlists.length; i++){
      if (playlists[i] instanceof PublicPlaylist){
        public = true;
      }
    }
    if (public){
      for (int i = 0; i < playlists.length; i++){
        if (playlists[i] instanceof PublicPlaylist){
          msg += "\n***********************************"
          msg += "\n**  Title: " + playlist[i].getPlaylistTitle();
          msg += "\n**  Punctuation: " + playlist[i].convertPunctuation();
          msg += "\n***********************************\n"
        }
      }
    } else {
      msg += "\n**  No hay Playlists Publicas.";
      msg += "\n***********************************";
    }
    return msg;
  }

  public double convertPunctuation(){
    double punctuation = 0;
    for (int i = 0; i < publicPunctuation.size(); i++){
      punctuation += publicPunctuation.get(i);
    }
    punctuation = punctuation/publicPunctuation.size();
    return punctuation;
  }
}
