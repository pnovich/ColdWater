package com.example.WaterAndGasMonitoring;

public class ClientNotFoundException extends RuntimeException{
    ClientNotFoundException(String name) {
        super("Client with " + name + " not found");
    }
}
