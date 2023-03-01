package com.deutsche.bank.demo.repository;

import com.deutsche.bank.demo.domain.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Nace entity.
 */
@Repository
public interface NaceRepository extends JpaRepository<Nace, Long> {
}
