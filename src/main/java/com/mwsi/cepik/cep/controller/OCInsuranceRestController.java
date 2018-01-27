package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.OCInsurance;
import com.mwsi.cepik.cep.model.form.OCInsuranceForm;
import com.mwsi.cepik.cep.service.OCInsuranceService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ocInsurance")
@AllArgsConstructor
public class OCInsuranceRestController {

    private final OCInsuranceService ocInsuranceService;

    @GetMapping("/{id}")
    public ResponseEntity<OCInsurance> findById(@PathVariable Long id) {
        return new ResponseEntity<>(ocInsuranceService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OCInsurance>> findAll() {
        return new ResponseEntity<>(ocInsuranceService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid OCInsuranceForm ocInsuranceForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        ocInsuranceService.add(ocInsuranceForm);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid OCInsuranceForm ocInsuranceForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        ocInsuranceService.update(ocInsuranceForm, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ocInsuranceService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
