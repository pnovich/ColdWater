package com.example.WaterAndGasMonitoring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(indexes = @Index(name = "clientIdIndex", columnList = "client_Id"))
public class ClientsDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client;
    private int gasValue;
    private int coldWaterValue;
    private int hotWaterValue;
    private LocalDate localDate;

    public ClientsDataRecord() {
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
                ", clientId=" + client.getId() +
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
