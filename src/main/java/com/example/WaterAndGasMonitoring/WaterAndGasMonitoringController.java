package com.example.WaterAndGasMonitoring;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class WaterAndGasMonitoringController {
    @Autowired
    WaterAndGasMonitoringService waterAndGasMonitoringService;

    @Operation(summary = "gets all records for specific user." +
            "Needs clientId numeric path variable for user. Example: http://localhost:8080/records/1")

    @GetMapping("/records/{id}")
    List<ClientsDataRecord> getAllRecordsForClient(@Valid @PathVariable ("id") int id) {

        return waterAndGasMonitoringService.getListOfRecordsByClientId(id);
    }

    @Operation(summary = "creates one record for specific user." +
            "Needs numeric clientId as path variable and json ClientsRecordDto." +
            "Example: http://localhost:8080/records/1" +
            "ClientsDataRecordDto: {\"gasValue\": 20,\"coldWaterValue\": 20,\"hotWaterValue\": 20}")


    @PostMapping("/records/{id}")
    ClientsDataRecord createClientsDataRecord(
            @PathVariable ("id") int id,
            @Valid @RequestBody ClientsDataRecordDto clientsDataRecordDto) {
        int clientsId = id;
        waterAndGasMonitoringService.validateClientId(clientsId);
        Client client = waterAndGasMonitoringService.getClientById(clientsId);
        ClientsDataRecord clientsDataRecord = waterAndGasMonitoringService.mapClientsDataRecordDtoToRecord(clientsDataRecordDto);
        clientsDataRecord.setClient(client);
        clientsDataRecord.setLocalDate(LocalDate.now());

        return waterAndGasMonitoringService.createClientsdataRecord(clientsDataRecord);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("not valid arguments", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> clientNotFoundException(ClientNotFoundException e) {
        return new ResponseEntity<>("client not found", HttpStatus.BAD_REQUEST);
    }

}
