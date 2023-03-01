package com.deutsche.bank.demo.rest;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.service.NaceService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NaceController {
  private final NaceService naceService;

  public NaceController(NaceService naceService) {
    this.naceService = naceService;
  }

  @PostMapping("/nace")
  public ResponseEntity<Nace> addNace(@RequestBody @Valid NaceDTO naceDTO) {
    log.info("Adding Nace: {}", naceDTO);
    Nace nace = naceService.addNace(naceDTO);
    return ResponseEntity.created(URI.create("/nace")).body(nace);
  }

  @GetMapping("/nace/{id}")
  public ResponseEntity<Nace> getNaceById(@PathVariable Long id) {
    log.info("Getting Nace by id: {}", id);
    Nace nace = naceService.getNaceById(id).orElse(null);
    if (nace == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(nace);
  }
}
