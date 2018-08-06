package com.jude.file.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
/**
 * @author jude
 */
@Getter
@Setter
@ToString
public class User {
  private Long id;

  private String userName;

  private String passWard;

  private String nickName;

  private String email;

  private String phoneNumber;

  private String status;

  private Date createTime;
}