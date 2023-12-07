package com.example.WaterAndGasMonitoring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ClientsDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int clientId;
    int gasValue;
    int coldWaterValue;
    int hotWaterValue;
    LocalDate localDate;

    public ClientsDataRecord() {
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
}
