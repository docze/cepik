package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriverRestController {

    private final DriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<Driver> findById(@PathVariable Long id) {
        return new ResponseEntity<>(driverService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> findAll() {
        return new ResponseEntity<>(driverService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Driver driver) {
        driverService.add(driver);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Driver driver, @PathVariable Long id) {
        driverService.update(driver, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        driverService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}