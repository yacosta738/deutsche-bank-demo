package com.deutsche.bank.demo.rest;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.service.NaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * REST controller for managing {@link Nace}.
 */
@Slf4j
@RestController
public class NaceController {
  private final NaceService naceService;

  public NaceController(NaceService naceService) {
    this.naceService = naceService;
  }

  /**
   * {@code POST  /nace} : Create a new nace.
   * @param naceDTO the nace to create.
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new nace, or with status {@code 400 (Bad Request)} if the nace has already an ID.
   */
  @Operation(summary = "Create a new Nace")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "201", description = "Nace created"),
          @ApiResponse(responseCode = "400", description = "Invalid request"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PostMapping("/nace")
  public ResponseEntity<Nace> addNace(@RequestBody @Valid NaceDTO naceDTO) {
    log.info("Adding Nace: {}", naceDTO);
    Nace nace = naceService.addNace(naceDTO);
    return ResponseEntity.created(URI.create("/nace")).body(nace);
  }

  /**
   * {@code GET  /nace/:id} : get the "id" nace.
   * @param id the id of the nace to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the nace, or with status {@code 404 (Not Found)}.
   */
  @Operation(summary = "Get Nace by id")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Nace found"),
          @ApiResponse(responseCode = "404", description = "Nace not found"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
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
