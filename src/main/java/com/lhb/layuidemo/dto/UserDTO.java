package com.lhb.layuidemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {
   private int code=0;
   private String msg="";
   private long count;
   private Object data;
}
