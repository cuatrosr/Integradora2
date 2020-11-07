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
  private final static int ADMIN_PLAYLIST = 3;
  private final static int EXIT_USER = 4;
  private final static int SHOW_USERS = 1;
  private final static int SHOW_SONG = 2;
  private final static int EXIT_ADMIN = 3;
  private final static int ADD_PLAYLIST = 1;
  private final static int PLAYLIST_PUNCTUATION = 2;
  private final static int SHOW_PLAY_PUNCTUATION = 3;
  private final static int EXIT_PLAYLIST = 4;
  private Genre[] allGenres = Genre.values();
  private MCS app = new MCS();

  private static Scanner sc = new Scanner(System.in);

  /**
  * Start the program. <br>
  * <b> pre: </b> Start the program. <br>
  * <b> post: </b> Start the program.
  */
  public void startProgram(){
    int choice = 0;
    firstPartProgram(choice, allGenres);
  }

  /**
  * Do the first part of the program.
  * <b> pre: </b> The method startProgram is initiated. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param allGenres Get the genres of the Genre class.
  */
  public void firstPartProgram(int choice, Genre[] allGenres){
    do {
      showFirstUser();
      choice = readOption(sc);
      doFirstOp(choice, allGenres);
    } while (choice != 4);
  }

  /**
  * Do the second part of the program, after the user log in.
  * <b> pre: </b> firstPartProgram choice = 2. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param allGenres Get the genres of the Genre class.
  * @param activeUser set the user that is connected.
  */
  public void secondPartProgram(int choice, Genre[] allGenres, int activeUser){
    do {
      showSecondUser();
      choice = readOption(sc);
      doSecondOp(choice, allGenres, activeUser);
    } while (choice != 4);
  }

  /**
  * Do the admin part of the program.
  * <b> pre: </b> firstPartProgram choice = 3. <br>
  * <b> post: </b> Make the method that the admin chose.
  * @param choice Read the user choice. 0 < choice < 4.
  */
  public void adminPartProgram(int choice){
    do{
      showAdmin();
      choice = readOption(sc);
      doAdminOp(choice);
    } while (choice != 3);
  }

  /**
  * Do the all the methods related to playlist, after the user log in.
  * <b> pre: </b> secondPartProgram choice = 3. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param activeUser get the user that is connected.
  */
  public void playlistProgram(int choice, int activeUser){
    do{
      showPlaylist();
      choice = readOption(sc);
      doPlaylistOp(choice, activeUser);
    } while(choice != 4);
  }

  /**
  * Show the first part of the program.
  * <b> pre: </b> firstPartProgram initiated. <br>
  * <b> post: </b> show the firstPartProgram Methods.
  */
  public void showFirstUser(){
    System.out.println("\n(1) Para registrarse en MCS.");
    System.out.println("(2) Para iniciar sesion en MCS.");
    System.out.println("(3) Para acceder a la vista admin.");
    System.out.println("(4) Para cerrar el programa.\n");
  }

  /**
  * Show the second part of the program.
  * <b> pre: </b> secondPartProgram initiated. <br>
  * <b> post: </b> show the secondPartProgram Methods.
  */
  public void showSecondUser(){
    System.out.println("\n(1) Añadir una cancion.");
    System.out.println("(2) Mostrar las canciones agregadas.");
    System.out.println("(3) Administrar Playlist.");
    System.out.println("(4) Log out.\n");
  }

  /**
  * Show the admin part of the program.
  * <b> pre: </b> adminPartProgram initiated. <br>
  * <b> post: </b> show the adminPartProgram Methods.
  */
  public void showAdmin(){
    System.out.println("\n(1) Mostrar todos los usuarios registrados.");
    System.out.println("(2) Mostrar todas las canciones registradas.");
    System.out.println("(3) Salir.\n");
  }

  /**
  * Show the playlist part of the program.
  * <b> pre: </b> playlistPartProgram initiated. <br>
  * <b> post: </b> show the playlistPartProgram Methods.
  */
  public void showPlaylist(){
    System.out.println("\n(1) Añadir una playlist.");
    System.out.println("(2) Puntua playlist.");
    System.out.println("(3) Ver puntuaciones de una playlist.");
    System.out.println("(4) Salir\n");
  }

  /**
  * Do the Methods of first part of the program.
  * <b> pre: </b> firstPartProgram choice = 2. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param allGenres Get the genres of the Genre class.
  */
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

  /**
  * Do the Methods of the second part of the program.
  * <b> pre: </b> secondPartProgram initiated. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param allGenres Get the genres of the Genre class.
  * @param activeUser set the user that is connected.
  */
  public void doSecondOp(int choice, Genre[] allGenres, int activeUser){
    switch (choice){
      case ADD_SONG:
        addInfoSong(sc, allGenres, activeUser);
        break;
      case SHOW_POOL_SONG:
        showPoolSongs();
        break;
      case ADMIN_PLAYLIST:
        playlistProgram(choice, activeUser);
        break;
      case EXIT_USER:
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  /**
  * Do the Methods of the admin part of the program.
  * <b> pre: </b> adminPartProgram initiated. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 4.
  */
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

  /**
  * Do the Methods of the playlist part of the program.
  * <b> pre: </b> playlistPartProgram initiated. <br>
  * <b> post: </b> Make the method that the user chose.
  * @param choice Read the user choice. 0 < choice < 5.
  */
  public void doPlaylistOp(int choice, int activeUser){
    switch (choice){
      case ADD_PLAYLIST:
        addPlaylist(sc, activeUser);
        break;
      case PLAYLIST_PUNCTUATION:
        addPunctuationPlaylist(sc);
        break;
      case SHOW_PLAY_PUNCTUATION:
        System.out.println(app.showPunctuation());
        break;
      case EXIT_PLAYLIST:
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  public void addPunctuationPlaylist(Scanner sc){
    System.out.println("\nPuntua la playlist del 1 al 5.");
    double prueba1 = sc.nextDouble();
    try {
        if (app.punctuationPlaylist(prueba1)){
        System.out.println("\nSe puntuo correctamente.");
      } else {
        System.out.println("\nNo se puntuo correctamente.");
      }
    }catch (NullPointerException e) {
    }
  }

  /**
  * add a playlist
  * <b> pre: </b> doPlaylistOp initiated. <br>
  * <b> post: </b> added a playlist of 3 different tipes.
  * @param activeUser get the user that is connected.
  */
  public void addPlaylist(Scanner sc, int activeUser){
    System.out.println("\nIngrese el nombre de su playlist");
    String playlistTitle = sc.nextLine();
    System.out.println("\nIngrese el tipo de playlist:");
    System.out.println("\n(1) Publica. \n(2) Privada. \n(3) Restringida.\n");
    int choice = sc.nextInt();
    User[] users = app.getUsers();
    switch (choice){
      case 1:
        System.out.println(app.addPlaylist(playlistTitle));
        break;
      case 2:
        User privateAdmin = users[activeUser];
        System.out.println(app.addPlaylist(playlistTitle, privateAdmin));
        break;
      case 3:
        User[] adminsRestringed = new User[5];
        adminsRestringed[0] = users[activeUser];
        System.out.println(app.addPlaylist(playlistTitle, adminsRestringed));
        break;
      default:
        System.out.println("\nOpcion invalida.");
    }
  }

  /**
  * Read the number by console.
  * <b> pre: </b> Scanner sc must be initiated <br>
  * <b> post: </b> Read the number that the user enter by console.
  * @param sc Read the user choice.
  */
  public int readOption(Scanner sc){
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
  }

  /**
  * Register the info user.
  * <b> pre: </b> secondPartProgram was initiated and choice = 1 <br>
  * <b> post: </b> Added user.
  * @param sc Read the user choice.
  */
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

  /**
  * Login user.
  * <b> pre: </b> secondPartProgram initiated. <br>
  * <b> post: </b> Succesfully user loged in.
  * @param sc Read the user choice.
  * @param choice Read the user choice. 0 < choice < 5.
  * @param allGenres Get the genres of the Genre class.
  */
  public void loginUser(Scanner sc, int choice, Genre[] allGenres){
    System.out.println("\nIngrese su nombre de usuario.");
    String userName = sc.nextLine();
    System.out.println("\nIngrese su contraseña.");
    String userPassword = sc.nextLine();
    User[] users = app.getUsers();
    boolean userRegistered = app.isUserRegistered(userName, userPassword, users);
    if (userRegistered){
      System.out.println("\nInicio sesion correctamente.");
      int activeUser = app.isActiveUser(userName, users);
      secondPartProgram(choice, allGenres, activeUser);
    } else {
      System.out.println("\nNo pudo iniciar sesion correctamente.");
    }
  }

  /**
  * Added song.
  * <b> pre: </b> secondPartProgram initiated. <br>
  * <b> post: </b> Succesfully added song.
  * @param sc Read the user choice.
  * @param allGenres Get the genres of the Genre class.
  * @param activeUser set the user that is connected.
  */
  public void addInfoSong(Scanner sc, Genre[] allGenres, int activeUser){
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
          share = app.shareSong(songTitle, songArtist, songDuration, genreChoice, activeUser);
          app.updateCategory(activeUser);
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

  /**
  * Show songs on pool.
  * <b> pre: </b> User loged in. <br>
  * <b> post: </b> show the songs on pool.
  */
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

  /**
  * Show all the users of the program.
  * <b> pre: </b> adminPartProgram initiated. <br>
  * <b> post: </b> show all the users of the program.
  */
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

  /**
  * Show all the songs of the program.
  * <b> pre: </b> adminPartProgram initiated. <br>
  * <b> post: </b> show all the songs of the program.
  */
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
