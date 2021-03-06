package com.ten.air.server.bean;

import org.smartboot.socket.transport.AioSession;

/**
 * Client连接对象 data transfer object
 */
public class BytesConnection {

    /*
     测试数据 0x16:
     A0 0F 24 12 08 0F 11 1E 14 01 11 22 33 44 55 66 77 88 99 AA BB CC DD EE FF 01 19 02 00 FA 00 00 00 00 FF FF
     |...| || |...............| || |..........................................| || |...| |...| |...| |...| |...|
     首部  长度      时间戳      功能码                设备号IMEI                  来源  数据  数据   数据   数据  校验和
    */

    private com.ten.air.protocol.bean.AirRecord airRecord;
    private AioSession<byte[]> session;

    private BytesConnection() {
    }

    public static BytesConnection newInstance(com.ten.air.protocol.bean.AirRecord airRecord, AioSession<byte[]> session) {
        BytesConnection instance = new BytesConnection();
        instance.airRecord = airRecord;
        instance.session = session;
        return instance;
    }

    @Override
    public String toString() {
        return "BytesConnection{" +
                "airRecord=" + airRecord +
                ", session=" + session +
                '}';
    }

    public com.ten.air.protocol.bean.AirRecord getAirRecord() {
        return airRecord;
    }

    public void setAirRecord(com.ten.air.protocol.bean.AirRecord airRecord) {
        this.airRecord = airRecord;
    }

    public AioSession<byte[]> getSession() {
        return session;
    }

    public void setSession(AioSession<byte[]> session) {
        this.session = session;
    }
}
