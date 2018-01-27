package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.form.DriverForm;
import com.mwsi.cepik.cek.service.DriverService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Driver> add(@RequestBody @Valid DriverForm driverForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(driverService.add(driverForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(@RequestBody @Valid DriverForm driverForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(driverService.update(driverForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        driverService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}