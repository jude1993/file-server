package com.jude.file.bean.mail.dao;

import com.jude.file.service.mail.interf.OperationLogService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：wupeng
 * @date ：Created in 16:51 2018/8/10
 * @description：
 */
@Getter
@Setter
@ToString
public class OperationLog {
    private Long id;
    private Long userId;
    private String operation;
    private Date createTime;

    public OperationLog(Long userId, String operation){
        this.userId = userId;
        this.operation = operation;
        this.createTime = new Date();
    }
}
