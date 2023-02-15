package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.example.entity.CodeGenerator;
import org.example.repository.CodeGeneratorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = {
    CodeGeneratorRepository.class,
    CodeGeneratorServiceImpl.class
})
class CodeGeneratorServiceImplTest {

  @MockBean
  private CodeGeneratorRepository repository;

  @SpyBean
  private CodeGeneratorService generatorService;

  @Test
  void whenZ9Z9_ThenReturnA0A0A0() {
    String code = "z9z9";
    CodeGenerator generator = new CodeGenerator().setId(1L).setCode("a0a0");
    when(repository.findById(1L)).thenReturn(Optional.of(generator));
    assertEquals("a0a0a0", generatorService.generateCode(code));
  }

  @Test
  void wheNullCode_ThenReturnA0A1() {
    CodeGenerator generator = new CodeGenerator().setId(1L).setCode("a0a0");
    when(repository.findById(1L)).thenReturn(Optional.of(generator));
    assertEquals("a0a1", generatorService.generateCode(null));
  }
}