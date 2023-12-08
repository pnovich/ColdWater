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
    public void initDb() {

        Client client1 = new Client("client1");
        Client client2 = new Client("client2");
        Client client3 = new Client("client3");
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        ClientsDataRecord clientsDataRecord = new ClientsDataRecord();
        clientsDataRecord.setClientId(1);
        clientsDataRecord.setColdWaterValue(10);
        clientsDataRecord.setHotWaterValue(10);
        clientsDataRecord.setGasValue(10);
        clientsDataRecord.setLocalDate(LocalDate.now());
        clientsDataRecordRepository.save(clientsDataRecord);
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

    public List<ClientsDataRecord> getAllClientsDataRecords(int id) {
        return clientsDataRecordRepository.findAll().stream()
                .filter(r -> r.getClientId() == id)
                .collect(Collectors.toList());
    }

    public int getClientIdByName(String name) {
    Client client = clientRepository.findAll().stream()
                .filter(c -> c.getClientName().equals(name))
                .findAny().orElseThrow(() -> new ClientNotFoundException(name));
    return client.getId();
    }

    public Client mapClient(ClientDto clientDto) {
        Client client = new Client();
        client.setClientName(clientDto.getName());
        return client;
    }

    public ClientsDataRecord mapClientsDataRecord(ClientsDataRecordDto clientsDataRecordDto) {
        ClientsDataRecord clientsDataRecord = new ClientsDataRecord();
        clientsDataRecord.setGasValue(clientsDataRecordDto.getGasValue());
        clientsDataRecord.setColdWaterValue(clientsDataRecordDto.getColdWaterValue());
        clientsDataRecord.setHotWaterValue(clientsDataRecordDto.getHotWaterValue());
        return clientsDataRecord;
    }

    public List<ClientsDataRecord> getAllAllRecords() {
        return clientsDataRecordRepository.findAll();
    }

    public List<Client> getAllALlClients() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

//    public ClientsDataRecordResponse mapToClientsDataRecordResponse(ClientsDataRecord record) {
//        ClientsDataRecordResponse response = new ClientsDataRecordResponse();
//        response.setId();
//    }
}
