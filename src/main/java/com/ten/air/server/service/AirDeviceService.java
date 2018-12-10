package com.ten.air.server.service;

import com.alibaba.fastjson.JSON;
import com.ten.air.server.bean.HttpResponse;
import com.ten.air.server.entity.AirDevice;
import com.ten.air.server.utils.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirDeviceService {
    private static final Logger logger = LoggerFactory.getLogger(AirDeviceService.class);
    private static final AirDeviceService INSTANCE = new AirDeviceService();

    public static AirDeviceService getInstance() {
        return INSTANCE;
    }

    private static final String DEVICE_URL = "http://localhost:8080/air/device";

    private HttpRequest http;

    private AirDeviceService() {
        http = new HttpRequest();
    }

    public HttpResponse insert(AirDevice pojo) {
        String params = JSON.toJSONString(pojo);
        String response = http.sendPost(DEVICE_URL, params);
        return JSON.parseObject(response, HttpResponse.class);
    }

    public HttpResponse update(AirDevice pojo) {
        String params = JSON.toJSONString(pojo);
        String response = http.sendUpdate(DEVICE_URL, params);
        return JSON.parseObject(response, HttpResponse.class);
    }
}