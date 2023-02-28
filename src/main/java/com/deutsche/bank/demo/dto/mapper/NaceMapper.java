package com.deutsche.bank.demo.dto.mapper;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NaceMapper {

  public Nace toEntity(NaceDTO naceDTO) {
    log.info("Mapping NaceDTO to Nace: {}", naceDTO);
    return Nace.builder()
        .level(naceDTO.getLevel())
        .code(naceDTO.getCode())
        .parent(naceDTO.getParent())
        .description(naceDTO.getDescription())
        .includes(naceDTO.getIncludes())
        .alsoIncludes(naceDTO.getAlsoIncludes())
        .rulings(naceDTO.getRulings())
        .excludes(naceDTO.getExcludes())
        .reference(naceDTO.getReference())
        .build();
  }
}
