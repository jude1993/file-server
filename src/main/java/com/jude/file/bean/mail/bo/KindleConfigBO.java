package com.jude.file.bean.mail.bo;

import com.jude.file.bean.mail.dao.KindleConfigDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jude
 */
@Getter
@Setter
@ToString
public class KindleConfigBO {
    private Long userId;

    private String kindleEmail;

    private Boolean status;

    public KindleConfigDO to() {
        KindleConfigDO kindleConfigDO = new KindleConfigDO();
        kindleConfigDO.setUserId(this.userId);
        if(StringUtils.isNotEmpty(this.kindleEmail)){
            kindleConfigDO.setKindleEmail(this.kindleEmail);
            kindleConfigDO.setStatus(true);
        }else{
            kindleConfigDO.setStatus(false);
        }
        return kindleConfigDO;
    }
}