package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.Authorisation;
import com.mwsi.cepik.cek.model.form.AuthorisationForm;
import com.mwsi.cepik.cek.service.AuthorisationService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authorisation")
@AllArgsConstructor
public class AuthorisationRestController {

    private final AuthorisationService authorisationService;

    @GetMapping("/{id}")
    public ResponseEntity<Authorisation> findById(@PathVariable Long id) {
        return new ResponseEntity<>(authorisationService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Authorisation>> findAll() {
        return new ResponseEntity<>(authorisationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid AuthorisationForm authorisationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        authorisationService.add(authorisationForm);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid AuthorisationForm authorisationForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        authorisationService.update(authorisationForm, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        authorisationService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
