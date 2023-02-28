package com.deutsche.bank.demo.service;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.dto.mapper.NaceMapper;
import com.deutsche.bank.demo.repository.NaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class NaceService {

  private final NaceRepository naceRepository;
  private final NaceMapper naceMapper;

  public NaceService(NaceRepository naceRepository, NaceMapper naceMapper) {
    this.naceRepository = naceRepository;
    this.naceMapper = naceMapper;
  }

  @Transactional
  public Nace addNace(NaceDTO naceDTO) {
    log.info("Adding Nace: {}", naceDTO);
    return naceRepository.save(naceMapper.toEntity(naceDTO));
  }
}
