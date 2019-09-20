package com.burton.lanbitou.test;

import lombok.Data;

import java.util.Date;

/**
 * @author Tainy
 * @date 2019-09-19 11:39
 */
@Data
public final class TestDomain {

    private String param1;

    private String param2;

    private Integer param3;

    private final Integer param4 = 0;

    private Date date;
}
