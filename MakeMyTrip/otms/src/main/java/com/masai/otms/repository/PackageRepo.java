package com.masai.otms.repository;

import com.masai.otms.models.Admin;
import com.masai.otms.models.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepo extends JpaRepository<Package, Integer>{
//    @Query("select p from Packages p where p.packageName=?1")
    List<Package> findByPackageName (String packageName);
}