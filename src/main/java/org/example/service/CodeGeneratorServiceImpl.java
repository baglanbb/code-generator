package org.example.service;

import javax.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.example.entity.CodeGenerator;
import org.example.repository.CodeGeneratorRepository;
import org.springframework.stereotype.Service;

@Service
public class CodeGeneratorServiceImpl implements CodeGeneratorService {

  private static final char MIN_CHAR = 'a';
  private static final char MAX_CHAR = 'z';
  private static final char MIN_NUMBER = '0';
  private static final char MAX_NUMBER = '9';

  private final CodeGeneratorRepository repository;

  public CodeGeneratorServiceImpl(CodeGeneratorRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public String generateCode(String s) {
    CodeGenerator generator = repository.findById(1L).orElseThrow();
    if (Strings.isEmpty(s)) {
      s = generator.getCode();
    }
    char[] chars = s.toCharArray();
    String code = String.valueOf(checkChar(chars, chars.length - 1));
    repository.save(generator.setCode(code));
    return code;
  }

  private char[] checkChar(char[] chars, int index) {
    if (index == -1) {
      return (String.valueOf(chars) + "a0").toCharArray();
    }
    if (chars[index] == MAX_NUMBER) {
      chars[index] = MIN_NUMBER;
      index = index - 1;
      chars = checkChar(chars, index);
    } else if (chars[index] == MAX_CHAR) {
      chars[index] = MIN_CHAR;
      index = index - 1;
      chars = checkChar(chars, index);
    } else {
      char c = chars[index];
      c++;
      chars[index] = c;
    }
    return chars;
  }
}
