package org.currencyConverter.userInterfaces;

import com.google.gson.*;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static org.currencyConverter.connections.Connection.request;

public class UserMenu {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static boolean showMainMenu(Scanner sc) throws IOException {
        boolean stay = true;
        var divisaCodeName = "";
        var divisaCodeConvert = "";

        System.out.println("1. USD => Peso Argentino");
        System.out.println("2. Peso Argentino => USD");
        System.out.println("3. USD => Real Brasileño");
        System.out.println("4. Real Brasileño => USD");
        System.out.println("5. USD => Peso Colombiano");
        System.out.println("6. Peso Colombiano => USD");
        System.out.println("0. Salir");
        System.out.println("Selecciona una opcion");
        char opt = sc.nextLine().charAt(0);
        switch(opt){
            case '1' -> {
                divisaCodeName = "USD";
                divisaCodeConvert = "ARS";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);
            }
            case '2' -> {
                divisaCodeName = "ARS";
                divisaCodeConvert = "USD";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);
            }
            case '3' -> {
                divisaCodeName = "USD";
                divisaCodeConvert = "BRL";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);
            }
            case '4' -> {
                divisaCodeName = "BRL";
                divisaCodeConvert = "USD";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);

            }
            case '5' -> {
                divisaCodeName = "USD";
                divisaCodeConvert = "COP";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);

            }
            case '6' -> {
                divisaCodeName = "COP";
                divisaCodeConvert = "USD";
                mergeAndPrint(divisaCodeName,divisaCodeConvert,sc);

            }
            case '0' -> stay=false;
            default -> throw new IllegalStateException("Unexpected value: " + opt);
        }
        return stay;
    }


    private static Double getChangeValue(HttpResponse<String> response, String divisaCodeConvert) throws IOException {
        try {
            JsonObject root = gson.fromJson(response.body(), JsonObject.class);
            JsonObject result = root.getAsJsonObject("result");
            return result.get(divisaCodeConvert).getAsDouble();
        }catch(Exception e){
            System.out.println("Error: \n"+e.getMessage());
            return null;
        }
    }

    private static double responseConverter(double changeValue, String name,Scanner sc) throws IOException {
        try{
            System.out.println("Ingresa la cantidad a convertir");
            double toConvert = sc.nextDouble();
            sc.nextLine();
            System.out.printf("RESULTADO:[[ %.2f %s son ", toConvert, name);
            return toConvert*changeValue;
        }catch(Exception e){
            System.out.println("Error: \n"+e.getMessage());
            return 0;
        }
    }

    private static void mergeAndPrint(String divisaCodeName, String divisaCodeConvert, Scanner sc) throws IOException {
        try{
            var response = request(divisaCodeName, divisaCodeConvert);
            double changeValue = getChangeValue(response,divisaCodeConvert);
            System.out.printf("%.2f %s ]]\n", responseConverter(changeValue, divisaCodeName,sc), divisaCodeConvert);
        }catch(Exception e){
            System.out.println("Error: \n"+e.getMessage());
        }
    }

}
