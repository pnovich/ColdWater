package com.example.WaterAndGasMonitoring;

public class ClientDto {
    String name;

    public ClientDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
