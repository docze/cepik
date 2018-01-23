package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.service.DrivingLicenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivingLicence")
@AllArgsConstructor
public class DrivingLicenceRestController {

    private final DrivingLicenceService drivingLicenceService;

    @GetMapping("/{id}")
    public ResponseEntity<DrivingLicence> findById(@PathVariable Long id) {
        return new ResponseEntity<>(drivingLicenceService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DrivingLicence>> findAll() {
        return new ResponseEntity<>(drivingLicenceService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody DrivingLicence drivingLicence) {
        drivingLicenceService.add(drivingLicence);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody DrivingLicence drivingLicence, @PathVariable Long id) {
        drivingLicenceService.update(drivingLicence, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        drivingLicenceService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
