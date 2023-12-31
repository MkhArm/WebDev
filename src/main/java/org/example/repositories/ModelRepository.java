package org.example.repositories;

import org.example.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    void deleteByBrand_Id(String brandId);

}
