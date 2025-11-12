package com.example.ccda_fhir_converter.controller;

import com.example.ccda_fhir_converter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ccda/convert")
public class PatientController {

    private final PatientService patientService;
        // Constructor injection is preferred over @Autowired field injection
        public PatientController(PatientService patientService) {
            this.patientService = patientService;
        }
        @PostMapping(
                value = "/patient",
                consumes = "application/xml",
                produces = "application/json"
        )
        public ResponseEntity<?> convertPatient(@RequestBody String xmlData) {
            try {
                String fhirJson = patientService.convertXmlToFhirJson(xmlData);
                return ResponseEntity.ok(fhirJson);
            } catch (IllegalArgumentException e) {
                // For invalid input or parsing issues
                return ResponseEntity.badRequest()
                        .body(Map.of("error", e.getMessage()));
            } catch (Exception e) {
                // For any other unexpected errors
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Map.of("error", "Unexpected error: " + e.getMessage()));
            }
        }
    }





