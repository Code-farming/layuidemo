package com.lhb.layuidemo.dto;

import lombok.Data;

@Data
public class SuccessDTO {
    private String msg;

    public SuccessDTO(String msg) {
        this.msg = msg;
    }
}
