package com.medical.util;



import cn.hutool.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }

    public static com.medical.util.R error(int code, String msg) {
        com.medical.util.R r = new com.medical.util.R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static com.medical.util.R ok(String msg) {
        com.medical.util.R r = new com.medical.util.R();
        r.put("msg", msg);
        return r;
    }

    public static com.medical.util.R ok(Map<String, Object> map) {
        com.medical.util.R r = new com.medical.util.R();
        r.putAll(map);
        return r;
    }

    public static com.medical.util.R ok() {
        return new com.medical.util.R();
    }

    public com.medical.util.R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
