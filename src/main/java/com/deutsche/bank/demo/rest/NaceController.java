package com.deutsche.bank.demo.rest;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.service.NaceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    return ResponseEntity.ok(nace);
  }
}
