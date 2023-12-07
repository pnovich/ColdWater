package com.example.WaterAndGasMonitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class WaterAndGasMonitoringController {
    @Autowired
    WaterAndGasMonitoringService waterAndGasMonitoringService;
    @GetMapping("/")
    String getDefaultString() {
        return "default string from monitoring";
    }

    @GetMapping("records")
    public List<ClientsDataRecord> getAllRecords() {
        return waterAndGasMonitoringService.getAllAllRecords();
    }

    @GetMapping("/clients")
    List<Client> getAllClients() {
        return waterAndGasMonitoringService.getAllALlClients();
    }

    @PostMapping("/clients")
    public Client registrateClient(@RequestBody ClientDto clientDto) {
        Client client = waterAndGasMonitoringService.mapClient(clientDto);
        return waterAndGasMonitoringService.saveClient(client);
    }

    @GetMapping("/records/{id}")
    List<ClientsDataRecord> getAllRecordsForClient(@PathVariable ("id") int id) {

        return waterAndGasMonitoringService.getAllClientsDataRecords(id);
    }

    @PostMapping("/records/{name}")
    ClientsDataRecord createClientsDataRecord(
//            @RequestBody ClientDto clientDto,
            @PathVariable ("name") String name,
                                              @RequestBody ClientsDataRecordDto clientsDataRecordDto) {
//        int clientsId = waterAndGasMonitoringService.getClientIdByName(clientDto.getName());
        int clientsId = waterAndGasMonitoringService.getClientIdByName(name);

        ClientsDataRecord clientsDataRecord = waterAndGasMonitoringService.mapClientsDataRecord(clientsDataRecordDto);
        clientsDataRecord.setClientId(clientsId);
        clientsDataRecord.setLocalDate(LocalDate.now());

        return waterAndGasMonitoringService.createClientsdataRecord(clientsDataRecord);
    }
}
