package com.deutsche.bank.demo.unit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.dto.mapper.NaceMapper;
import com.deutsche.bank.demo.repository.NaceRepository;
import com.deutsche.bank.demo.service.NaceService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class NaceServiceTest {

  @Mock
  private NaceMapper naceMapper;
  @Mock
  private NaceRepository naceRepository;
  private NaceService naceService;

  private Nace nace;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    naceMapper = mock(NaceMapper.class);
    naceRepository = mock(NaceRepository.class);
    naceService = new NaceService(naceRepository, naceMapper);
    nace = Nace.builder()
        .id(1L)
        .level(1)
        .code("code")
        .parent("parent")
        .description("description")
        .includes("includes")
        .alsoIncludes("alsoIncludes")
        .rulings("rulings")
        .excludes("excludes")
        .reference("reference")
        .build();
  }

  @Test
  void addNace() {
    when(naceMapper.toEntity(any(NaceDTO.class))).thenReturn(nace);
    when(naceRepository.save(any(Nace.class))).thenReturn(nace);
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("code")
        .parent("parent")
        .description("description")
        .includes("includes")
        .alsoIncludes("alsoIncludes")
        .rulings("rulings")
        .excludes("excludes")
        .reference("reference")
        .build();
    Nace storeNace = naceService.addNace(naceDTO);
    assertThat(storeNace).isEqualTo(nace);
  }

  @Test
  void getNace() {
    when(naceRepository.findById(any(Long.class))).thenReturn(Optional.of(nace));
    Optional<Nace> naceById = naceService.getNaceById(1L);
    assertThat(naceById).isPresent();
    Nace n = naceById.get();
    assertThat(n).isEqualTo(nace);
  }
}
