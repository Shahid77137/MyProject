package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
