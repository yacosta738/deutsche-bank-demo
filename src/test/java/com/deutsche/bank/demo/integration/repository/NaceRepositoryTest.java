package com.deutsche.bank.demo.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.integration.testcontainer.AbstractPostgreSQLTestContainerIT;
import com.deutsche.bank.demo.repository.NaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
class NaceRepositoryTest extends AbstractPostgreSQLTestContainerIT {
  @Autowired
  private NaceRepository naceRepository;

  @Test
  void testAddNace() {
    Nace nace = Nace.builder()
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
    Nace n = naceRepository.save(nace);
    assertEquals(nace.getId(), n.getId());
    assertEquals(nace.getLevel(), n.getLevel());
    assertEquals(nace.getCode(), n.getCode());
    assertEquals(nace.getParent(), n.getParent());
    assertEquals(nace.getDescription(), n.getDescription());
    assertEquals(nace.getIncludes(), n.getIncludes());
    assertEquals(nace.getAlsoIncludes(), n.getAlsoIncludes());
    assertEquals(nace.getRulings(), n.getRulings());
    assertEquals(nace.getExcludes(), n.getExcludes());
    assertEquals(nace.getReference(), n.getReference());

  }
}
