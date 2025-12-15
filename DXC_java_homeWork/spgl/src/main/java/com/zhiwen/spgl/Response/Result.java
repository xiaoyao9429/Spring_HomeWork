package com.zhiwen.spgl.Response;

import lombok.Data;
import lombok.Getter;

@Data
public class Result {//响应体

    private Integer code;
    private String msg;
    private Object data;

   public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result success() {
       Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

     public static Result error(String msg) {
        Result result = new Result();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }
}
