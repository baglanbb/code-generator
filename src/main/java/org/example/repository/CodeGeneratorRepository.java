package org.example.repository;

import org.example.entity.CodeGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGeneratorRepository extends JpaRepository<CodeGenerator, Long> {

}
