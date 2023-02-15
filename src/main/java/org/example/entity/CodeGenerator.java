package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "code_generator")
@Accessors(chain = true)
public class CodeGenerator {

  @Id
  private Long id;

  @Column(name = "code", nullable = false)
  private String code;

}
