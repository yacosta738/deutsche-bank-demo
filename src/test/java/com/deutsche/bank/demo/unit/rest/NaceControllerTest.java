package com.deutsche.bank.demo.unit.rest;


import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.deutsche.bank.demo.domain.Nace;
import com.deutsche.bank.demo.dto.NaceDTO;
import com.deutsche.bank.demo.dto.mapper.NaceMapper;
import com.deutsche.bank.demo.rest.NaceController;
import com.deutsche.bank.demo.service.NaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(NaceController.class)
class NaceControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private NaceMapper naceMapper;
  @MockBean
  private NaceService naceService;

  private ObjectMapper objectMapper;

  private Nace nace;

  @BeforeEach
  public void setUp() {
    objectMapper = new ObjectMapper();
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
  void addNace() throws Exception {
    when(naceService.addNace(any(NaceDTO.class))).thenReturn(nace);

    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.level", is(1)))
        .andExpect(jsonPath("$.code", is("code")))
        .andExpect(jsonPath("$.parent", is("parent")))
        .andExpect(jsonPath("$.description", is("description")))
        .andExpect(jsonPath("$.includes", is("includes")))
        .andExpect(jsonPath("$.alsoIncludes", is("alsoIncludes")))
        .andExpect(jsonPath("$.rulings", is("rulings")))
        .andExpect(jsonPath("$.excludes", is("excludes")))
        .andExpect(jsonPath("$.reference", is("reference")));
  }

  @Test
  void addNaceWithNullLevel() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .code("code")
            .parent("parent")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullCode() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .parent("parent")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullParent() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullDescription() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullIncludes() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .description("description")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullAlsoIncludes() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .description("description")
            .includes("includes")
            .rulings("rulings")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullRulings() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .excludes("excludes")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullExcludes() throws Exception {
    mvc.perform(post("/nace")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(NaceDTO.builder()
            .level(1)
            .code("code")
            .parent("parent")
            .description("description")
            .includes("includes")
            .alsoIncludes("alsoIncludes")
            .rulings("rulings")
            .reference("reference")
            .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullReference() throws Exception {
    mvc.perform(post("/nace")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(NaceDTO.builder()
                .level(1)
                .code("code")
                .parent("parent")
                .description("description")
                .includes("includes")
                .alsoIncludes("alsoIncludes")
                .rulings("rulings")
                .excludes("excludes")
                .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void addNaceWithNullAll() throws Exception {
    mvc.perform(post("/nace")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(NaceDTO.builder()
                .build())))
        .andExpect(status().isBadRequest());
  }

  @Test
  void findNaceById() throws Exception {
    when(naceService.getNaceById(1L)).thenReturn(Optional.of(nace));
    mvc.perform(get("/nace/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.level", is(1)))
        .andExpect(jsonPath("$.code", is("code")))
        .andExpect(jsonPath("$.parent", is("parent")))
        .andExpect(jsonPath("$.description", is("description")))
        .andExpect(jsonPath("$.includes", is("includes")))
        .andExpect(jsonPath("$.alsoIncludes", is("alsoIncludes")))
        .andExpect(jsonPath("$.rulings", is("rulings")))
        .andExpect(jsonPath("$.excludes", is("excludes")))
        .andExpect(jsonPath("$.reference", is("reference")));
  }

  @Test
  void findNaceByIdNotFound() throws Exception {
    when(naceService.getNaceById(1L)).thenReturn(Optional.empty());
    mvc.perform(get("/nace/13342"))
        .andExpect(status().isNotFound());
  }
}
