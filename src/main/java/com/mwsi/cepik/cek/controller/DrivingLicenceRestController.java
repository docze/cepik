package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.model.form.DrivingLicenceForm;
import com.mwsi.cepik.cek.service.DrivingLicenceService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<DrivingLicence> add(@RequestBody @Valid DrivingLicenceForm drivingLicenceForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(drivingLicenceService.add(drivingLicenceForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrivingLicence> update(@RequestBody @Valid DrivingLicenceForm drivingLicenceForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(drivingLicenceService.update(drivingLicenceForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        drivingLicenceService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
