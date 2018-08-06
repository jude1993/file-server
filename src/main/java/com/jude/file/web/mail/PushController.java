package com.jude.file.web.mail;

import com.jude.file.bean.ResponseBean;
import com.jude.file.bean.mail.bo.MailBO;
import com.jude.file.service.mail.interf.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：wupeng
 * @date ：Created in 16:04 2018/8/6
 * @description：
 */
@RestController
@RequestMapping("mail/kindle")
public class PushController {
    @Autowired
    private PushService pushService;

    @RequestMapping(value="push",method = RequestMethod.POST)
    public ResponseBean push(@RequestBody MailBO mailBO){
        Long userId = 1L;
        return pushService.push(userId,mailBO);
    }
}
