package com.example.WaterAndGasMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ClientsDataRecordRepository extends JpaRepository<ClientsDataRecord, Integer> {
    List<ClientsDataRecord> findByClientId(int clientId);

    @Transactional
    void deleteByClientId(int clientId);
}
