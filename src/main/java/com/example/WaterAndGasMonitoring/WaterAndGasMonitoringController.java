package com.example.WaterAndGasMonitoring;

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

    @GetMapping("/records/{id}")
    List<ClientsDataRecord> getAllRecordsForClient(@Valid @PathVariable ("id") int id) {

        return waterAndGasMonitoringService.getRecordsForClientsIdWithQuery(id);
    }

    @PostMapping("/records/{id}")
    ClientsDataRecord createClientsDataRecord(
            @PathVariable ("id") int id,
            @Valid @RequestBody ClientsDataRecordDto clientsDataRecordDto) {
        int clientsId = id;
        waterAndGasMonitoringService.validateClientId(clientsId);
        ClientsDataRecord clientsDataRecord = waterAndGasMonitoringService.mapClientsDataRecordDtoToRecord(clientsDataRecordDto);
        clientsDataRecord.setClientId(clientsId);
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
