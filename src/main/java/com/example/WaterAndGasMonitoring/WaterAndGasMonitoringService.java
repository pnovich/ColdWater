package com.example.WaterAndGasMonitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaterAndGasMonitoringService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientsDataRecordRepository clientsDataRecordRepository;

    public ClientsDataRecord createClientsdataRecord(ClientsDataRecord clientsDataRecord) {
        return clientsDataRecordRepository.save(clientsDataRecord);
    }

    @PostConstruct
    public void init() {
        initDb();
    }

    public void validateClientId(int clientId) throws ClientNotFoundException {
        List<Client> clients = clientRepository.findAll();
        List<Integer> ids = clients.stream()
                .map(c -> {return c.getId();})
                .collect(Collectors.toList());
        if (!ids.contains(clientId)) {
            throw new ClientNotFoundException("client id = " + clientId);
        }

    }

    public ClientsDataRecord mapClientsDataRecordDtoToRecord(ClientsDataRecordDto clientsDataRecordDto) {
        ClientsDataRecord clientsDataRecord = new ClientsDataRecord();
        clientsDataRecord.setGasValue(clientsDataRecordDto.getGasValue());
        clientsDataRecord.setColdWaterValue(clientsDataRecordDto.getColdWaterValue());
        clientsDataRecord.setHotWaterValue(clientsDataRecordDto.getHotWaterValue());
        return clientsDataRecord;
    }

    public List<ClientsDataRecord> getRecordsForClientsIdWithQuery(int clientId) {
        long time1 = System.currentTimeMillis();
        List<ClientsDataRecord> result = clientsDataRecordRepository.getAllRecordsForCurrentClient(clientId);
        long time2 = System.currentTimeMillis();
        long actualTime = time2 - time1;
        System.out.println("time for selecting records = " + actualTime);
        return result;
    }

    public void initDb() {

        Client client1 = new Client("client1");
        Client client2 = new Client("client2");
        Client client3 = new Client("client3");
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        ClientsDataRecord clientsDataRecord1 = new ClientsDataRecord();
        clientsDataRecord1.setClientId(1);
        clientsDataRecord1.setColdWaterValue(10);
        clientsDataRecord1.setHotWaterValue(10);
        clientsDataRecord1.setGasValue(10);
        clientsDataRecord1.setLocalDate(LocalDate.now());

        ClientsDataRecord clientsDataRecord2 = new ClientsDataRecord();
        clientsDataRecord2.setClientId(1);
        clientsDataRecord2.setColdWaterValue(10);
        clientsDataRecord2.setHotWaterValue(10);
        clientsDataRecord2.setGasValue(10);
        clientsDataRecord2.setLocalDate(LocalDate.now());

        clientsDataRecordRepository.save(clientsDataRecord1);
        clientsDataRecordRepository.save(clientsDataRecord2);
    }

}
