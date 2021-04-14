package com.assimilate.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyDetailRepository extends JpaRepository<FamilyDetailsEntity, Integer> {
// git test
}
