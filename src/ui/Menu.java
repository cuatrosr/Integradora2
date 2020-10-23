package ui;
import java.util.Scanner;
import java.io.IOException;
import model.*;

public class Menu{

  private final static int MAX_USERS = 10;
  private final static int REGISTER_USER = 1;
  private final static int LOGIN_USER = 2;
  private final static int EXIT = 3;
  private User[] users = new User[MAX_USERS];

  private static Scanner sc = new Scanner(System.in);

  public void startProgram(){
    int choice;

    do {
      showFirstUser();
      choice = readOption(sc);
      doOpUser(choice);
    } while (choice != 3);
  }

  public void showFirstUser(){
    System.out.println("\n(1) Para registrarse en MCS.");
    System.out.println("(2) Para iniciar sesion en MCS.");
    System.out.println("(3) Para cerrar el programa.\n");
  }

  public void doOpUser(int choice){
    switch (choice){
      case REGISTER_USER:
        registerUser(sc);
        break;
      case LOGIN_USER:
        loginUser(sc);
        break;
      case EXIT:
        break;
      default:
        System.out.println("\nOpcion invalida, repita nuevamente.");
    }
  }

  public void registerUser(Scanner sc){
    System.out.println("\nIngrese su nombre de usuario (Sin espacios).");
    String userName = sc.nextLine();
    System.out.println("\nIngrese su contraseña.");
    String userPassword = sc.nextLine();
    System.out.println("\nIngrese su edad.");
    int userAge = sc.nextInt();
    boolean added = false;
    for (int i = 0; i < MAX_USERS && !added; i++){
      if (users[i] == null){
        users[i] = new User(userName, userPassword, userAge);
        added = true;
      }
    }
    if (added){
      System.out.println("\nSe registro correctamente.");
    } else {
      System.out.println("\nNo se registro correctamente.");
    }
  }

  public void loginUser(){
    System.out.println("Ingrese su nombre de usuario.");
    String userName = sc.nextLine();
    System.out.println("Ingrese su contraseña.");
    String userPassword = sc.nextLine();
  }

  public int readOption(Scanner sc){
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
  }
}
