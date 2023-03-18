package com.deutsche.bank.demo.repository;

import com.deutsche.bank.demo.domain.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Spring Data  repository for the Nace entity.
 */
@Repository
public interface NaceRepository extends JpaRepository<Nace, Long> {
    Optional<Nace> findByCode(String code);
}
