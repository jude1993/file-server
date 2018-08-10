package com.jude.file.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：wupeng
 * @date ：Created in 17:12 2018/8/10
 * @description：
 */
@Getter
@Setter
@ToString
public class PageCondition {
    private Integer pageIndex;
    private Integer pageSize;
    private Object condition;
}
