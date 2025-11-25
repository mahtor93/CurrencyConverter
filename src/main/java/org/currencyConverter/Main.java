package org.currencyConverter;
import java.io.IOException;
import java.util.Scanner;
import static org.currencyConverter.userInterfaces.UserMenu.showMainMenu;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        System.out.println("\n----------------------------------------");
        System.out.println("|| Bienvenido al conversor de monedas ||");
        System.out.println("----------------------------------------");
        while(quit){
            quit = showMainMenu(sc);
        }
    }
}