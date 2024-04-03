package com.rfp11.mybookrecipe.repositories;

import com.rfp11.mybookrecipe.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
