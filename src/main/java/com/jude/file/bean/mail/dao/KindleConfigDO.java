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
public class KindleConfigDO {
    private Long userId;

    private String kindleEmail;

    private Boolean status;

    public static KindleConfigDO init(Long userId) {
        KindleConfigDO kindleConfigDO = new KindleConfigDO();
        kindleConfigDO.setUserId(userId);
        kindleConfigDO.setStatus(false);
        return kindleConfigDO;
    }
}