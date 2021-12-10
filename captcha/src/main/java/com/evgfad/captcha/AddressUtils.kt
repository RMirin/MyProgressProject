/*
package com.evgfad.captcha

import android.content.Context
import com.evgfad.captcha.RiskTypeEnum
import com.evgfad.captcha.AddressUtils
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.evgfad.captcha.network.GeeTestApi
import java.net.MalformedURLException
import java.net.URL
import javax.inject.Inject

class AddressUtils @Inject constructor(private val context: Context, geeTestApi: GeeTestApi) {
    fun getRegister(context: Context, typeEnum: RiskTypeEnum): String? {
        return joinUrl(context, typeEnum, true)
    }

    fun getValidate(context: Context, typeEnum: RiskTypeEnum): String? {
        return joinUrl(context, typeEnum, false)
    }

    private fun joinUrl(context: Context, typeEnum: RiskTypeEnum, isRegister: Boolean): String? {
        val base = getPreferences(context).getString(
            "settings_address_base",
            "https://www.geetest.com/demo/gt/"
        )
        val type: String = if (typeEnum == RiskTypeEnum.OTHER) {
            return if (isRegister) getPreferences(context).getString(
                "settings_address_api1",
                "https://www.geetest.com/demo/gt/register-slide"
            ) else getPreferences(context)
                .getString(
                    "settings_address_api2",
                    "https://www.geetest.com/demo/gt/validate-slide"
                )
        } else {
            typeEnum.type
        }
        return base + (if (isRegister) "register-" else "validate-") + type
    }

    private fun subUrl(address: String, typeEnum: RiskTypeEnum, isRegister: Boolean): String {
        if (typeEnum == RiskTypeEnum.OTHER) {
            return address
        }
        try {
            val url = URL(address)
            val path = url.path.substring(0, url.path.lastIndexOf("/"))
            val register_base = URL(url.protocol, url.host, path).toString()
            return register_base + (if (isRegister) "/register-" else "/validate-") + typeEnum.type
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return address
    }

    private fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}*/
