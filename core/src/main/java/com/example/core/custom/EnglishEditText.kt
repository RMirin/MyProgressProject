package com.example.core.custom

import android.annotation.SuppressLint
import android.content.Context
import android.os.LocaleList
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.TintContextWrapper
import com.example.core.R
import java.util.*

class EnglishEditText : AppCompatEditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, R.attr.editTextStyle) {
        init()
    }

    @SuppressLint("RestrictedApi")
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(TintContextWrapper.wrap(context), attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        imeHintLocales = LocaleList(Locale("en", "USA"))
    }

//    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
//        super.onFocusChanged(focused, direction, previouslyFocusedRect)
//        callOnClick()
//    }

    override fun onKeyPreIme(key_code: Int, event: KeyEvent): Boolean {
        if (key_code == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_UP) clearFocus()
        return super.onKeyPreIme(key_code, event)
    }
}