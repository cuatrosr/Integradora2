package ui;
import java.util.*;
import model.*;

public class Menu{

  private final static int REGISTER_USER = 1;
  private final static int LOGIN_USER = 2;
  private final static int ADMIN_VIEW = 3;
  private final static int EXIT_PROGRAM = 4;
  private final static int ADD_SONG = 1;
  private final static int SHOW_POOL_SONG = 2;
  private final static int EXIT_USER = 3;
  private final static int SHOW_USERS = 1;
  private final static int SHOW_SONG = 2;
  private final static int EXIT_ADMIN = 3;
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
    } while (choice != 4);
  }

  public void secondPartProgram(int choice, Genre[] allGenres){
    do {
      showSecondUser();
      choice = readOption(sc);
      doSecondOp(choice, allGenres);
    } while (choice != 3);
  }

  public void adminPartProgram(int choice){
    do {
      showAdmin();
      choice = readOption(sc);
      doAdminOp(choice);
    } while (choice != 3);
  }

  public void showFirstUser(){
    System.out.println("\n(1) Para registrarse en MCS.");
    System.out.println("(2) Para iniciar sesion en MCS.");
    System.out.println("(3) Para acceder a la vista admin.");
    System.out.println("(4) Para cerrar el programa.\n");
  }

  public void showSecondUser(){
    System.out.println("\n(1) Añadir una cancion.");
    System.out.println("(2) Mostrar las canciones agregadas.");
    System.out.println("(3) Log out.\n");
  }

  public void showAdmin(){
    System.out.println("\n(1) Mostrar todos los usuarios registrados.");
    System.out.println("(2) Mostrar todas las canciones registradas.");
    System.out.println("(3) Salir.\n");
  }

  public void doFirstOp(int choice, Genre[] allGenres){
    switch (choice){
      case REGISTER_USER:
        registerInfoUser(sc);
        break;
      case LOGIN_USER:
        loginUser(sc, choice, allGenres);
        break;
      case ADMIN_VIEW:
        adminPartProgram(choice);
        break;
      case EXIT_PROGRAM:
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
      case SHOW_POOL_SONG:
        showPoolSongs();
        break;
      case EXIT_USER:
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  public void doAdminOp(int choice){
    switch (choice){
      case SHOW_USERS:
        showTotalUsers();
        break;
      case SHOW_SONG:
        showSongs();
        break;
      case EXIT_ADMIN:
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
    String msg = (added) ? "\nLa cancion Se añadio correctamente." : "\nLa cancion No se añadio correctamente.";
    System.out.println(msg);
    int choice = 0;
    boolean share = false;
    do {
      System.out.println("\n¿Desea compartir la cancion en el pool de canciones?\n SI(1) / NO(2)\n");
      choice = readOption(sc);
      switch (choice){
        case 1:
          share = app.shareSong(songTitle, songArtist, songDuration, genreChoice);
          break;
        case 2:
          break;
        default:
          System.out.println("\nOpcion invalida, repita nuevamente.");
      }
    } while (choice != 1 && choice != 2);
    msg = (share) ? "\nLa cancion Fue compartida con exito." : "\nLa cancion No fue compartida con exito.";
    System.out.println(msg);
  }

  public void showPoolSongs(){
    Song[] pool = app.getPoolSongs();
    if (pool[0] == null) {
      System.out.println("\nNo hay canciones en el pool.");
    } else {
      System.out.println("\nHay " + app.getTotalSongsPool() + " canciones en el pool.");
      for (int i = 0; i < pool.length; i++){
        if (pool[i] != null){
          System.out.println("\n**************  Song **************");
          System.out.println("**  Title: " + pool[i].getSongTitle());
          System.out.println("**  Artist: " + pool[i].getSongArtist());
          int songDuration = pool[i].getSongDuration();
          System.out.println("**  Duration: " + Song.convertSongDuration(songDuration));
          System.out.println("**  Genre: " + pool[i].getGenre());
          System.out.println("***********************************\n");
        }
      }
    }
  }

  public void showTotalUsers(){
    User[] users = app.getUsers();
    if (users[0] != null){
      System.out.println("\nHay " + app.getTotalUsers() + " usuarios registrados.\n");
      for (int i = 0; i < users.length; i++){
        if (users[i] != null){
          System.out.println("*************  User **************");
          System.out.println("**  UserName: " + users[i].getUserName());
          System.out.println("**  Age: " + users[i].getUserAge());
          System.out.println("**  Category: " + users[i].getUserCategory());
          System.out.println("***********************************\n");
        }
      }
    } else {
      System.out.println("\nNo hay usuarios registrados todavia.");
    }
  }

  public void showSongs(){
    ArrayList<Song> songs = app.getSongs();
    if (songs.isEmpty()){
      System.out.println("\nNo hay canciones todavia.");
    } else {
      System.out.println("\nHay " + songs.size() + " canciones registradas.\n");
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
