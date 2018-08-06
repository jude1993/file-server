package com.jude.file.bean.mail.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jude
 */
@Getter
@Setter
@ToString
public class KindleConfig {
    private Long userId;

    private String kindleEmail;

    private Boolean status;
}