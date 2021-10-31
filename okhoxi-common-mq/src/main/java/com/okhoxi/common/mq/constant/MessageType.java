package com.okhoxi.common.mq.constant;

import com.okhoxi.common.core.constant.Status;

/**
 * @author Mr.Tang on 2021/9/13 13:49.
 */
public enum MessageType implements Status {

    MSG_PAY(1, "支付消息"),           // 支付平台回调的付费通知，支付成功等消息
    MSG_USER(2, "用户个人中心消息"),  // 运营推送
    MSG_ETL(3, "图数据生成消息"),     // 设计平台数据转分析平台图数据
    MSG_DIAGRAM(4, "绘图消息"),       // 箱图，电源图，平面布置图等
    MSG_OPERATE(5, "操作日志消息"),   // 关键操作，比如删除盘表，创建点表等
    MSG_ABILITY(6, "租户资源限制"),   // 例如租户过期
    MSG_AUDIT(7, "审核消息"),         // 例如审核通过或者不通过

    ;

    private Integer code;
    private String desc;

    MessageType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }



    @Override
    public String getDesc() {
        return desc;
    }

}

