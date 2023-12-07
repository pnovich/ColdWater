package com.example.WaterAndGasMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsDataRecordRepository extends JpaRepository<ClientsDataRecord, Integer> {
}
