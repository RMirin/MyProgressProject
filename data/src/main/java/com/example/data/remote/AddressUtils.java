package com.example.data.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chensongsong on 2020/8/26.
 */
public class AddressUtils {

    public static String getRegister(Context context, RiskTypeEnum typeEnum) {
        return joinUrl(context, typeEnum, true);
    }

    public static String getValidate(Context context, RiskTypeEnum typeEnum) {
        return joinUrl(context, typeEnum, false);
    }

    private static String joinUrl(Context context, RiskTypeEnum typeEnum, boolean isRegister) {
        String base = getPreferences(context).getString("settings_address_base", "https://www.geetest.com/demo/gt/");
        String type;
        if (typeEnum == RiskTypeEnum.OTHER) {
            return isRegister ? getPreferences(context).getString("settings_address_api1", "https://www.geetest.com/demo/gt/register-slide")
                    : getPreferences(context).getString("settings_address_api2", "https://www.geetest.com/demo/gt/validate-slide");
        } else {
            type = typeEnum.type;
        }
        return base + (isRegister ? "register-" : "validate-") + type;

    }

    private static String subUrl(String address, RiskTypeEnum typeEnum, boolean isRegister) {
        if (typeEnum == RiskTypeEnum.OTHER) {
            return address;
        }
        try {
            URL url = new URL(address);
            String path = url.getPath().substring(0, url.getPath().lastIndexOf("/"));
            String register_base = new URL(url.getProtocol(), url.getHost(), path).toString();
            return register_base + (isRegister ? "/register-" : "/validate-") + typeEnum.type;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return address;
    }

    private static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}

