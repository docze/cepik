package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.CarModel;
import com.mwsi.cepik.cep.model.form.CarModelForm;
import com.mwsi.cepik.cep.service.CarModelService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carModel")
@AllArgsConstructor
public class CarModelRestController {

    private final CarModelService carModelService;

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> findById(@PathVariable Long id) {
        return new ResponseEntity<>(carModelService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarModel>> findAll() {
        return new ResponseEntity<>(carModelService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarModel> add(@RequestBody @Valid CarModelForm carModelForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(carModelService.add(carModelForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarModel> update(@RequestBody @Valid CarModelForm carModelForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(carModelService.update(carModelForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        carModelService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
