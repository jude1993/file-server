package com.jude.file.bean.mail.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 16:07 2018/8/6
 * @description：
 */
@Getter
@Setter
@ToString
public class MailBO {
    private String title;
    private String message;
    private List<String> filePath;
}
