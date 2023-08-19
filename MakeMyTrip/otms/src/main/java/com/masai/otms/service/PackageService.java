package com.masai.otms.service;

import com.masai.otms.models.Package;

import java.util.List;

public interface PackageService {
    Package addPackage(Package p);
    String deletePackage(Integer id);
    Package searchPackage(Integer id);
    List<Package> viewAllPackage();
}
