package com.masai.otms.controller;

import com.masai.otms.models.Package;
import com.masai.otms.repository.PackageRepo;
import com.masai.otms.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    PackageService pServ;

    @Autowired
    private PackageRepo pRepo;

    @PostMapping("/save-package")
    public ResponseEntity<Package> addPackage(@Valid @RequestBody Package p) {
        return ResponseEntity.ok(pServ.addPackage(p));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deletePackage(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(pServ.deletePackage(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Package>> searchPackage(@Valid @PathVariable String name) {
        return ResponseEntity.ok(pRepo.findByPackageName(name));
    }

    @GetMapping("/all-packages")
    public ResponseEntity<List<Package>> viewAllPackage() {
        return ResponseEntity.ok(pServ.viewAllPackage());
    }
}
