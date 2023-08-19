package com.masai.otms.service.Implementations;


import com.masai.otms.exceptions.PackageException;
import com.masai.otms.models.Package;
import com.masai.otms.repository.PackageRepo;
import com.masai.otms.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    PackageRepo pRepo;

    @Override
    public Package addPackage(Package p) {
        return pRepo.save(p);
    }

    @Override
    public String deletePackage(Integer id) {
        Package p = pRepo.findById(id).orElseThrow(() -> new PackageException("Incorrect Package Id"));
        pRepo.delete(p);
        return "Package has been removed.";
    }

    @Override
    public Package searchPackage(Integer id) {
        return pRepo.findById(id).orElseThrow(() -> new PackageException("Incorrect Package Id"));
    }

    @Override
    public List<Package> viewAllPackage() {
        return pRepo.findAll();
    }
}
