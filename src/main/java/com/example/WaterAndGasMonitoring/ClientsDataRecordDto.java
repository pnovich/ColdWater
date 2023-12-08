package com.example.WaterAndGasMonitoring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientsDataRecordDto {

    @Min(0)
    @Max(999999)
    @NotNull
    int gasValue;

    @Min(0)
    @Max(999999)
    @NotNull
    int coldWaterValue;

    @Min(0)
    @Max(999999)
    @NotNull
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
