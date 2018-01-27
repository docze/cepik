package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.Vehicle;
import com.mwsi.cepik.cep.model.form.VehicleForm;
import com.mwsi.cepik.cep.service.VehicleService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleRestController {

    private final VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid VehicleForm vehicleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        vehicleService.add(vehicleForm);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid VehicleForm vehicleForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        vehicleService.update(vehicleForm, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
