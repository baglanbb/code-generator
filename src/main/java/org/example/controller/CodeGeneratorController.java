package org.example.controller;

import org.example.service.CodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeGeneratorController {

  private final CodeGeneratorService codeGenerator;

  @Autowired
  public CodeGeneratorController(CodeGeneratorService codeGenerator) {
    this.codeGenerator = codeGenerator;
  }

  @GetMapping("/next-code")
  public ResponseEntity<String> getNextCode(
      @RequestParam(name = "current-code") String currentCode) {
    return ResponseEntity.ok(codeGenerator.generateCode(currentCode));
  }
}
