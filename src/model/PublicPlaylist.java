package model;
import java.util.*;
import ui.*;

public class PublicPlaylist extends Playlist{

  private int ammountPunctuation = 0;
  private MCS app = new MCS();

  public PublicPlaylist(String playlistTitle){
    super(playlistTitle);
  }

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
