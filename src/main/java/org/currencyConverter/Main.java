package org.currencyConverter;

import org.currencyConverter.connections.Connection;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(
                Connection.request("fetch-one?from=USD&to=EUR")
        );
    }
}