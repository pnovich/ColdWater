package com.example.WaterAndGasMonitoring;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(indexes = @Index(name = "clientIdIndex", columnList = "clientId"))
public class ClientsDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "clientId")
    private int clientId;
    private int gasValue;
    private int coldWaterValue;
    private int hotWaterValue;
    private LocalDate localDate;

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

    @Override
    public String toString() {
        return "ClientsDataRecord{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", gasValue=" + gasValue +
                ", coldWaterValue=" + coldWaterValue +
                ", hotWaterValue=" + hotWaterValue +
                ", localDate=" + localDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
