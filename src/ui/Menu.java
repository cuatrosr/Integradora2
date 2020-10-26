package ui;
import java.util.*;
import model.*;

public class Menu{

  private final static int REGISTER_USER = 1;
  private final static int LOGIN_USER = 2;
  private final static int EXIT = 3;
  private final static int ADD_SONG = 1;
  private final static int SHOW_SONG = 2;
  private Genre[] allGenres = Genre.values();
  private MCS app = new MCS();

  private static Scanner sc = new Scanner(System.in);

  public void startProgram(){
    int choice = 0;
    firstPartProgram(choice, allGenres);
  }

  public void firstPartProgram(int choice, Genre[] allGenres){
    do {
      showFirstUser();
      choice = readOption(sc);
      doFirstOp(choice, allGenres);
    } while (choice != 3);
  }

  public void secondPartProgram(int choice, Genre[] allGenres){
    do {
      showSecondUser();
      choice = readOption(sc);
      doSecondOp(choice, allGenres);
    } while (choice != 3);
  }

  public void showFirstUser(){
    System.out.println("\n(1) Para registrarse en MCS.");
    System.out.println("(2) Para iniciar sesion en MCS.");
    System.out.println("(3) Para cerrar el programa.\n");
  }

  public void showSecondUser(){
    System.out.println("\n(1) Añadir una cancion.");
    System.out.println("(2) Mostrar las canciones agregadas.");
    System.out.println("(3) Log out.\n");
  }

  public void doFirstOp(int choice, Genre[] allGenres){
    switch (choice){
      case REGISTER_USER:
        registerInfoUser(sc);
        break;
      case LOGIN_USER:
        loginUser(sc, choice, allGenres);
        break;
      case EXIT:
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  public void doSecondOp(int choice, Genre[] allGenres){
    switch (choice){
      case ADD_SONG:
        addInfoSong(sc, allGenres);
        break;
      case SHOW_SONG:
        showSongs();
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  public int readOption(Scanner sc){
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
  }

  public void registerInfoUser(Scanner sc){
    System.out.println("\nIngrese su nombre de usuario (Sin espacios):");
    String userName = sc.nextLine();
    System.out.println("\nIngrese su contraseña:");
    String userPassword = sc.nextLine();
    System.out.println("\nIngrese su edad:");
    int userAge = sc.nextInt();
    boolean register = app.registerUser(userName, userPassword, userAge);
    if (register){
      System.out.println("\nEl usuario Se registro correctamente.");
    } else {
      System.out.println("\nEl usuario No se registro correctamente.");
    }
  }

  public void loginUser(Scanner sc, int choice, Genre[] allGenres){
    System.out.println("\nIngrese su nombre de usuario.");
    String userName = sc.nextLine();
    System.out.println("\nIngrese su contraseña.");
    String userPassword = sc.nextLine();
    User[] users = app.getUsers();
    boolean userRegistered = app.isUserRegistered(userName, userPassword, users);
    if (userRegistered){
      System.out.println("\nInicio sesion correctamente.");
      secondPartProgram(choice, allGenres);
    } else {
      System.out.println("\nNo pudo iniciar sesion correctamente.");
    }
  }

  public void addInfoSong(Scanner sc, Genre[] allGenres){
    System.out.println("\nIngrese el nombre de la cancion:");
    String songTitle = sc.nextLine();
    System.out.println("\nIngrese el artista de la cancion:");
    String songArtist = sc.nextLine();
    System.out.println("\nIngrese la duracion de la cancion en segundos:");
    int songDuration = sc.nextInt();
    Song.printAllGenre(allGenres);
    int genreChoice = sc.nextInt();
    genreChoice--;
    boolean added = app.addSong(songTitle, songArtist, songDuration, genreChoice);
    if (added){
      System.out.println("\nLa cancion Se añadio correctamente.");
    } else {
      System.out.println("\nLa cancion No se añadio correctamente.");
    }
  }

  public void showSongs(){
    ArrayList<Song> songs = app.getSongs();
    if (songs.isEmpty()){
      System.out.println("\nNo hay canciones todavia.");
    } else {
      System.out.println("\nEstas son las canciones que estan registradas.\n");
      for (int i = 0; i < songs.size(); i++){
        System.out.println("**************  Song **************");
        System.out.println("**  Title: " + songs.get(i).getSongTitle());
        System.out.println("**  Artist: " + songs.get(i).getSongArtist());
        int songDuration = songs.get(i).getSongDuration();
        System.out.println("**  Duration: " + Song.convertSongDuration(songDuration));
        System.out.println("**  Genre: " + songs.get(i).getGenre());
        System.out.println("***********************************\n");
      }
    }
  }
}
