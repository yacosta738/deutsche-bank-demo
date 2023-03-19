package com.deutsche.bank.demo.integration.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.integration.TestController;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class NaceControllerTest extends TestController {
  @Test
  void addNace() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(201, naceResponseEntity.getStatusCode().value());
    Nace nace = naceResponseEntity.getBody();
    assertNotNull(nace);
    assertEquals(naceDTO.getLevel(), nace.getLevel());
    assertEquals(naceDTO.getCode(), nace.getCode());
    assertEquals(naceDTO.getParent(), nace.getParent());
    assertEquals(naceDTO.getDescription(), nace.getDescription());
    assertEquals(naceDTO.getIncludes(), nace.getIncludes());
    assertEquals(naceDTO.getAlsoIncludes(), nace.getAlsoIncludes());
    assertEquals(naceDTO.getRulings(), nace.getRulings());
    assertEquals(naceDTO.getExcludes(), nace.getExcludes());
    assertEquals(naceDTO.getReference(), nace.getReference());
  }

  @Test
  void addNaceWithNullLevel() {
    NaceDTO naceDTO = NaceDTO.builder()
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullCode() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullParent() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullDescription() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullIncludes() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullAlsoIncludes() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullRulings() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullExcludes() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .reference("H")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void addNaceWithNullReference() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .build();
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    assertEquals(400, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void findNaceById() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> storeEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    Nace nace = Objects.requireNonNull(
        storeEntity.getBody());
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.getForEntity("/nace/" + nace.getId(),
        Nace.class);
    assertEquals(200, naceResponseEntity.getStatusCode().value());
    Nace naceFound = naceResponseEntity.getBody();
    assertNotNull(naceFound);
    assertEquals(nace.getLevel(), naceFound.getLevel());
    assertEquals(nace.getCode(), naceFound.getCode());
    assertEquals(nace.getParent(), naceFound.getParent());
    assertEquals(nace.getDescription(), naceFound.getDescription());
    assertEquals(nace.getIncludes(), naceFound.getIncludes());
    assertEquals(nace.getAlsoIncludes(), naceFound.getAlsoIncludes());
    assertEquals(nace.getRulings(), naceFound.getRulings());
    assertEquals(nace.getExcludes(), naceFound.getExcludes());
    assertEquals(nace.getReference(), naceFound.getReference());
  }

  @Test
  void findNaceByIdNotFound() {
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.getForEntity("/nace/146232",
        Nace.class);
    assertEquals(404, naceResponseEntity.getStatusCode().value());
  }

  @Test
  void findNaceByCode() {
    NaceDTO naceDTO = NaceDTO.builder()
        .level(1)
        .code("A")
        .parent("B")
        .description("C")
        .includes("D")
        .alsoIncludes("E")
        .rulings("F")
        .excludes("G")
        .reference("H")
        .build();
    ResponseEntity<Nace> storeEntity = testRestTemplate.postForEntity("/nace", naceDTO,
        Nace.class);
    Nace nace = Objects.requireNonNull(
        storeEntity.getBody());
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.getForEntity("/nace/c/" + nace.getCode(),
        Nace.class);
    assertEquals(200, naceResponseEntity.getStatusCode().value());
    Nace naceFound = naceResponseEntity.getBody();
    assertNotNull(naceFound);
    assertEquals(nace.getLevel(), naceFound.getLevel());
    assertEquals(nace.getCode(), naceFound.getCode());
    assertEquals(nace.getParent(), naceFound.getParent());
    assertEquals(nace.getDescription(), naceFound.getDescription());
    assertEquals(nace.getIncludes(), naceFound.getIncludes());
    assertEquals(nace.getAlsoIncludes(), naceFound.getAlsoIncludes());
    assertEquals(nace.getRulings(), naceFound.getRulings());
    assertEquals(nace.getExcludes(), naceFound.getExcludes());
    assertEquals(nace.getReference(), naceFound.getReference());
  }

  @Test
  void findNaceByCodeNotFound() {
    ResponseEntity<Nace> naceResponseEntity = testRestTemplate.getForEntity("/nace/c/146232",
        Nace.class);
    assertEquals(404, naceResponseEntity.getStatusCode().value());
  }
}
