package com.burton.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Tainy
 * @date 2019/6/20 18:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable{

    private Integer id;

    private String goodsName;

    private Integer goodsPrice;
}
