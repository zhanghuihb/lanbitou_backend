package com.burton.common.domain.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tainy
 * @date 2019/7/3 11:00
 */
@Data
@NoArgsConstructor
public class DeepCopy implements Cloneable{

    private String param3;

    private DeepCopy deepCopy;

    @Override
    public DeepCopy clone() throws CloneNotSupportedException {
        return (DeepCopy)super.clone();
    }

    public DeepCopy(String param3) {
        this.param3 = param3;
    }
}
