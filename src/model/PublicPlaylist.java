package model;
import java.util.*;
import ui.*;

public class PublicPlaylist extends Playlist{

  private int ammountPunctuation = 0;
  private MCS app = new MCS();

  /**
  * Create a public playlist.
  * <b> pre: </b> addPlaylist was initiated. <br>
  * <b> post: </b> Create a public playlist.
  * @param playlistTitle playlistTitle != null.
  */
  public PublicPlaylist(String playlistTitle){
    super(playlistTitle);
  }

  /**
  * Do the average of the punctuation.
  * <b> pre: </b> publicPunctuation != null. <br>
  * <b> post: </b> Make the average of the punctuation.
  * @return punctuation
  */
  @Override
  public double convertPunctuation(){
    double punctuation = 0;
    double suma = 0;
    ArrayList<Double> publicPunctuation = app.getPublicPunctuation();
    for (int i = 0; i < publicPunctuation.size(); i++){
      suma = publicPunctuation.get(i);
      punctuation += suma;
    }
    punctuation = punctuation/publicPunctuation.size();
    return punctuation;
  }
}
