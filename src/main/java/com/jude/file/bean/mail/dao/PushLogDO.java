package com.jude.file.bean.mail.dao;

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
public class PushLogDO {
    private Long id;

    private Long userId;

    private String emailAddress;

    private String fileName;

    private Boolean success;

    private Date pushTime;

    private Integer retry;

    public PushLogDO(Long userId, String emailAddress, String fileName, Boolean success, Date pushTime){
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.fileName = fileName;
        this.pushTime = pushTime;
        this.success = success;
    }
}