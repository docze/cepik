package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.CarBrand;
import com.mwsi.cepik.cep.model.form.CarBrandForm;
import com.mwsi.cepik.cep.service.CarBrandService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carBrand")
@AllArgsConstructor
public class CarBrandRestController {

    private final CarBrandService carBrandService;

    @GetMapping("/{id}")
    public ResponseEntity<CarBrand> findById(@PathVariable Long id) {
        return new ResponseEntity<>(carBrandService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarBrand>> findAll() {
        return new ResponseEntity<>(carBrandService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarBrand> add(@RequestBody @Valid CarBrandForm carBrandForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        carBrandService.add(carBrandForm);
        return new ResponseEntity<>(carBrandService.add(carBrandForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarBrand> update(@RequestBody @Valid CarBrandForm carBrandForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        carBrandService.update(carBrandForm, id);
        return new ResponseEntity<>(carBrandService.update(carBrandForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        carBrandService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
