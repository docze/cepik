package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.CarOwner;
import com.mwsi.cepik.cep.model.form.CarOwnerForm;
import com.mwsi.cepik.cep.service.CarOwnerService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carOwner")
@AllArgsConstructor
public class CarOwnerRestController {

    private final CarOwnerService carOwnerService;

    @GetMapping("/{id}")
    public ResponseEntity<CarOwner> findById(@PathVariable Long id) {
        return new ResponseEntity<>(carOwnerService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarOwner>> findAll() {
        return new ResponseEntity<>(carOwnerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid CarOwnerForm carOwnerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        carOwnerService.add(carOwnerForm);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid CarOwnerForm carOwnerForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        carOwnerService.update(carOwnerForm, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        carOwnerService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
