package com.deutsche.bank.demo.service;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.dto.mapper.NaceMapper;
import com.deutsche.bank.demo.repository.NaceRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing Nace.
 */
@Service
@Slf4j
public class NaceService {

  private final NaceRepository naceRepository;
  private final NaceMapper naceMapper;

  public NaceService(NaceRepository naceRepository, NaceMapper naceMapper) {
    this.naceRepository = naceRepository;
    this.naceMapper = naceMapper;
  }

  /**
   * Add a new Nace.
   *
   * @param naceDTO the entity to save.
   * @return the persisted entity.
   */
  @Transactional
  public Nace addNace(NaceDTO naceDTO) {
    log.info("Adding Nace: {}", naceDTO);
    return naceRepository.save(naceMapper.toEntity(naceDTO));
  }

  /**
   * Get one nace by id.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  @Transactional(readOnly = true)
  public Optional<Nace> getNaceById(Long id) {
    log.info("Finding Nace by id: {}", id);
    return naceRepository.findById(id);
  }

  /**
   * Get one nace by code.
   *
   * @param code the code of the entity.
   * @return the entity.
   */
  @Transactional(readOnly = true)
  public Optional<Nace> getNaceByCode(String code) {
    log.info("Finding Nace by code: {}", code);
    return naceRepository.findByCode(code);
  }
}
