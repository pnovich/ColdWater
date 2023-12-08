package com.example.WaterAndGasMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsDataRecordRepository extends JpaRepository<ClientsDataRecord, Integer> {

    @Query("select record from ClientsDataRecord record where record.clientId = ?1")
    List<ClientsDataRecord> getAllRecordsForCurrentClient(int clientId);
}
