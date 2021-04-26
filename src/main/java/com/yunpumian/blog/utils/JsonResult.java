package com.yunpumian.blog.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wn
 * @program : coupon
 * @descript :给前端返回固定数据类型
 * @create :2020-12-31 15:26
 */

public class JsonResult {
    private Map<String, Object> dataMap = new HashMap<>();

    //针对code

    public void setCode(Object code) {
        dataMap.put("code", code);
    }
    //针对msg

    public void setMsg(String msg) {
        dataMap.put("code", msg);
    }

    //针对data

    public void setData(Object data) {
        dataMap.put("data", data);
    }

    //可定制的键值对

    public void put(String key, Object value) {
        dataMap.put(key, value);

    }

    public Map<String, Object> getValues() {
        return dataMap;
    }
}
