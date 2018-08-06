package com.jude.file.bean;

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
    private Object data;

    public ResponseBean(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseBean success(String message,Object data){
        return new ResponseBean("1",message,data);
    }

    public static ResponseBean success(String message){
        return new ResponseBean("1",message,null);
    }

    public static ResponseBean fail(String message,Object data){
        return new ResponseBean("0",message,data);
    }

    public static ResponseBean fail(String message){
        return new ResponseBean("0",message,null);
    }

    public static ResponseBean error(String message,Object data){
        return new ResponseBean("-1",message,data);
    }

    public static ResponseBean error(String message){
        return new ResponseBean("-1",message,null);
    }
}
