package com.evgfad.captcha;

/**
 * Created by chensongsong on 2020/8/26.
 */
public enum RiskTypeEnum {

    SLIDE("slide"),
    CLICK("click"),
    FULLPAGE("fullpage"),
    VOICE("voice"),
    OTHER("other");

    public String type;

    RiskTypeEnum(String type) {
        this.type = type;
    }
}
