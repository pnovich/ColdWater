package com.example.WaterAndGasMonitoring;

import java.time.LocalDate;

public class ClientsDataRecordResponse {
    private int id;
    private int clientId;
    private int gasValue;
    private int coldWaterValue;
    private int hotWaterValue;
    private LocalDate localDate;

    public ClientsDataRecordResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getGasValue() {
        return gasValue;
    }

    public void setGasValue(int gasValue) {
        this.gasValue = gasValue;
    }

    public int getColdWaterValue() {
        return coldWaterValue;
    }

    public void setColdWaterValue(int coldWaterValue) {
        this.coldWaterValue = coldWaterValue;
    }

    public int getHotWaterValue() {
        return hotWaterValue;
    }

    public void setHotWaterValue(int hotWaterValue) {
        this.hotWaterValue = hotWaterValue;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "ClientsDataRecordResponse{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", gasValue=" + gasValue +
                ", coldWaterValue=" + coldWaterValue +
                ", hotWaterValue=" + hotWaterValue +
                ", localDate=" + localDate +
                '}';
    }
}
