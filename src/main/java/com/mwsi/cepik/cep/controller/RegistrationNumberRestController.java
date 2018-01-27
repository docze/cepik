package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.RegistrationNumber;
import com.mwsi.cepik.cep.model.form.RegistrationNumberForm;
import com.mwsi.cepik.cep.service.RegistrationNumberService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registrationNumber")
@AllArgsConstructor
public class RegistrationNumberRestController {

    private final RegistrationNumberService registrationNumberService;

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationNumber> findById(@PathVariable Long id) {
        return new ResponseEntity<>(registrationNumberService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RegistrationNumber>> findAll() {
        return new ResponseEntity<>(registrationNumberService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationNumber> add(@RequestBody @Valid RegistrationNumberForm registrationNumberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(registrationNumberService.add(registrationNumberForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationNumber> update(@RequestBody @Valid RegistrationNumberForm registrationNumberForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(registrationNumberService.update(registrationNumberForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        registrationNumberService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
