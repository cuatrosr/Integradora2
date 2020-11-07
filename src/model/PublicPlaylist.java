package model;
import java.util.*;
import ui.*;

public class PublicPlaylist extends Playlist{

  private ArrayList<Double> publicPunctuation;
  private int ammountPunctuation = 0;

  public PublicPlaylist(String playlistTitle, int songDuration, Genre genres){
    super(playlistTitle, songDuration, genres);
    publicPunctuation = new ArrayList<Double>();
  }

  public ArrayList<Double> getPublicPunctuation(){
    return publicPunctuation;
  }

  @Override
  public double convertPunctuation(){
    double punctuation = 0;
    for (int i = 0; i < publicPunctuation.size(); i++){
      punctuation += publicPunctuation.get(i);
    }
    punctuation = punctuation/publicPunctuation.size();
    return punctuation;
  }
}
