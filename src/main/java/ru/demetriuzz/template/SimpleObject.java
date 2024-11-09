package ru.demetriuzz.template;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SimpleObject {

    private Integer id;
    private String name;
    private BigDecimal coast;
    private boolean flag;

}
