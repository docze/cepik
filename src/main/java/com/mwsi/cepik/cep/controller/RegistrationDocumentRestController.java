package com.mwsi.cepik.cep.controller;

import com.mwsi.cepik.cep.model.RegistrationDocument;
import com.mwsi.cepik.cep.model.form.RegistrationDocumentForm;
import com.mwsi.cepik.cep.service.RegistrationDocumentService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registrationDocument")
@AllArgsConstructor
public class RegistrationDocumentRestController {

    private final RegistrationDocumentService registrationDocumentService;

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDocument> findById(@PathVariable Long id) {
        return new ResponseEntity<>(registrationDocumentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDocument>> findAll() {
        return new ResponseEntity<>(registrationDocumentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationDocument> add(@RequestBody @Valid RegistrationDocumentForm registrationDocumentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(registrationDocumentService.add(registrationDocumentForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDocument> update(@RequestBody @Valid RegistrationDocumentForm registrationDocumentForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(registrationDocumentService.update(registrationDocumentForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        registrationDocumentService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
