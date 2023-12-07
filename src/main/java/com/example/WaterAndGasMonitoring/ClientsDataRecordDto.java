package com.example.WaterAndGasMonitoring;

public class ClientsDataRecordDto {
    int gasValue;
    int coldWaterValue;
    int hotWaterValue;

    public ClientsDataRecordDto() {
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

    @Override
    public String toString() {
        return "ClientsDataRecordDto{" +
                "gasValue=" + gasValue +
                ", coldWaterValue=" + coldWaterValue +
                ", hotWaterValue=" + hotWaterValue +
                '}';
    }
}
