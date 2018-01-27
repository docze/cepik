package com.mwsi.cepik.cek.controller;

import com.mwsi.cepik.cek.model.PenaltyPoints;
import com.mwsi.cepik.cek.model.form.PenaltyPointsForm;
import com.mwsi.cepik.cek.service.PenaltyPointsService;
import com.mwsi.cepik.exception.FormValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/penaltyPoints")
@AllArgsConstructor
public class PenaltyPointsRestController {

    private final PenaltyPointsService penaltyPointsService;

    @GetMapping("/{id}")
    public ResponseEntity<PenaltyPoints> findById(@PathVariable Long id) {
        return new ResponseEntity<>(penaltyPointsService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PenaltyPoints>> findAll() {
        return new ResponseEntity<>(penaltyPointsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PenaltyPoints> add(@RequestBody @Valid PenaltyPointsForm penaltyPointsForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(penaltyPointsService.add(penaltyPointsForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PenaltyPoints> update(@RequestBody @Valid PenaltyPointsForm penaltyPointsForm, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(penaltyPointsService.update(penaltyPointsForm, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        penaltyPointsService.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
