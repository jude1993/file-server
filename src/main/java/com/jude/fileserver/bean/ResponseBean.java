package com.jude.fileserver.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jude
 */
@Getter
@Setter
@ToString
public class ResponseBean {
    private String code;
    private String message;
    private String data;

    public ResponseBean(String code, String message, String data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
