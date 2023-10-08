/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongame;

/**
 *
 * @author Kyla
 */
import java.util.Scanner;

public class PokemonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tHI THERE! WELCOME TO THE POKEMON GAME.");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter your Pokemon's name: ");
        String pokemonName = scanner.nextLine();

        String pokemonType = "";
        boolean validType = false;

        while (!validType) {
            System.out.println("\nChoose your Pokemon type:");
            System.out.println("1. Fairy type");
            System.out.println("2. Poison type");
            System.out.println("3. Ghost type");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pokemonType = "Fairy";
                    validType = true;
                    break;
                case 2:
                    pokemonType = "Poison";
                    validType = true;
                    break;
                case 3:
                    pokemonType = "Ghost";
                    validType = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid Pokemon type.");
                    break;
            }
        }


        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

        boolean readyForBattle = false;

        while (!readyForBattle) {
            System.out.println("\nWhat would you like to do with your Pokemon?");
            System.out.println("1. Train");
            System.out.println("2. Rest");
            System.out.println("3. Display Stats");
            System.out.println("4. Quit");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    pokemon.train();
                    break;
                case 2:
                    pokemon.rest();
                    break;
                case 3:
                    pokemon.displayStats();
                    break;
                case 4:
                    System.out.println("You quit the game.");
                    readyForBattle = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }

            if (!readyForBattle) {
                System.out.print("Are you ready to enter your Pokemon into a battle? (Y for yes/ Other key for no): ");
                String readyChoice = scanner.next().toLowerCase();
                if (readyChoice.equals("y")) {
                    readyForBattle = true;
                    pokemon.enterBattle();
                }
            }
        }
    }
}


