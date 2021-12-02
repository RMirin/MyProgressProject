package com.example.core.custom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.Paint.FontMetrics
import android.util.AttributeSet
import android.util.SparseArray
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import androidx.annotation.IntDef
import androidx.core.content.ContextCompat
import com.example.core.R
import java.math.BigDecimal
import kotlin.math.sqrt

@SuppressLint("Recycle")
class CustomSeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    companion object {
        const val NONE = -1
        const val SIDES = 0
        const val BOTTOM_SIDES = 1
        const val BELOW_SECTION_MARK = 2
    }

    @IntDef(*[NONE, SIDES, BOTTOM_SIDES, BELOW_SECTION_MARK])
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class TextPosition

    private var mMin = 0F
    private var mMax = 0F
    private var mProgress = 0F
    private var isFloatType = false
    private var mTrackSize = 0
    private var mSecondTrackSize = 0
    private var mThumbRadius = 0
    private var mThumbRadiusOnDragging = 0
    private var mTrackColor = 0
    private var mSecondTrackColor = 0
    private var mThumbColor = 0
    private var mSectionCount = 0
    private var isShowSectionMark = false
    private var isAutoAdjustSectionMark = false
    private var isShowSectionText = false
    private var mSectionTextSize = 0
    private var mSectionTextColor = 0

    @TextPosition
    private var mSectionTextPosition = NONE
    private var mSectionTextInterval = 0
    private var isShowThumbText = false
    private var mThumbTextSize = 0
    private var mThumbTextColor = 0
    private var isShowProgressInFloat = false
    private var isTouchToSeek = false
    private var isSeekStepSection = false
    private var isSeekBySection = false
    private var mAnimDuration = 0L
    private var isAlwaysShowCustom = false
    private var mAlwaysShowCustomDelay = 0L
    private var isHideCustom = false
    private var isRtl = false

    private var mCustomColor = 0
    private var mCustomTextSize = 0
    private var mCustomTextColor = 0

    private var mDelta = 0F
    private var mSectionValue = 0F
    private var mThumbCenterX = 0F
    private var mTrackLength = 0F
    private var mSectionOffset = 0F
    private var isThumbOnDragging = false
    private var mTextSpace = 0
    private var triggerBubbleShowing = false
    private var mSectionTextArray = SparseArray<String>()
    private var mPreThumbCenterX = 0F
    private var triggerSeekBySection = false

   // private lateinit var mProgressListener: OnProgressChangedListener
    private var mLeft = 0F
    private var mRight = 0F
    private var mPaint = Paint()
    private var mRectText = Rect()

    private var mWindowManager: WindowManager
    private lateinit var mCustomView: CustomView
    private var mCustomRadius = 0
    private var mCustomCenterRawSolidX = 0F
    private var mCustomCenterRawSolidY = 0F
    private var mCustomCenterRawX = 0F
    private lateinit var mLayoutParams: WindowManager.LayoutParams
    private val mPoint = IntArray(2)
    private val isTouchToSeekAnimEnd = true
    private var mPreSecValue = 0F

    init {
        val valueContext =
            context.obtainStyledAttributes(attrs, R.styleable.CustomSeekBar, defStyle, 0)
        mMin = valueContext.getFloat(R.styleable.CustomSeekBar_csb_min, 0.0F)
        mMax = valueContext.getFloat(R.styleable.CustomSeekBar_csb_max, 0.0F)
        mProgress = valueContext.getFloat(R.styleable.CustomSeekBar_csb_progress, mMin)
        isFloatType = valueContext.getBoolean(R.styleable.CustomSeekBar_csb_is_float_type, false)
        mTrackSize =
            valueContext.getDimensionPixelSize(R.styleable.CustomSeekBar_csb_track_size, dp2px(2))
        mSecondTrackSize = valueContext.getDimensionPixelSize(
            R.styleable.CustomSeekBar_csb_second_track_size,
            mTrackSize + dp2px(2)
        )
        mThumbRadius = valueContext.getDimensionPixelSize(
            R.styleable.CustomSeekBar_csb_second_track_size,
            mSecondTrackSize + dp2px(2)
        )
        mThumbRadiusOnDragging = valueContext.getDimensionPixelSize(
            R.styleable.CustomSeekBar_csb_thumb_radius_on_dragging,
            mSecondTrackSize * 2
        )
        mSectionCount = valueContext.getInteger(R.styleable.CustomSeekBar_csb_section_count, 10)
        mTrackColor = valueContext.getColor(
            R.styleable.CustomSeekBar_csb_track_color,
            ContextCompat.getColor(context, R.color.colorPrimaryDark)
        )
        mSecondTrackColor = valueContext.getColor(
            R.styleable.CustomSeekBar_csb_second_track_color,
            ContextCompat.getColor(context, R.color.colorPrimary)
        )
        mThumbColor =
            valueContext.getColor(R.styleable.CustomSeekBar_csb_thumb_color, mSecondTrackColor)
        isShowSectionText =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_show_section_text, false)
        mSectionTextSize = valueContext.getDimensionPixelSize(
            R.styleable.CustomSeekBar_csb_section_text_size,
            sp2px(14)
        )
        mSectionTextColor =
            valueContext.getColor(R.styleable.CustomSeekBar_csb_section_text_color, mTrackColor)
        isSeekStepSection =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_seek_step_section, false)
        isSeekBySection =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_seek_by_section, false)
        val pos = valueContext.getInteger(R.styleable.CustomSeekBar_csb_section_text_position, NONE)
        if (pos == 0) {
            mSectionTextPosition = SIDES
        } else if (pos == 1) {
            mSectionTextPosition = BOTTOM_SIDES
        } else if (pos == 2) {
            mSectionTextPosition = BELOW_SECTION_MARK
        } else {
            mSectionTextPosition = NONE
        }
        mSectionTextInterval =
            valueContext.getInteger(R.styleable.CustomSeekBar_csb_section_text_interval, 1)
        isShowThumbText =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_show_thumb_text, false)
        mThumbTextSize = valueContext.getDimensionPixelSize(
            R.styleable.CustomSeekBar_csb_thumb_text_size,
            sp2px(14)
        )
        mThumbTextColor =
            valueContext.getColor(R.styleable.CustomSeekBar_csb_thumb_text_color, mSecondTrackColor)
        mCustomColor =
            valueContext.getColor(R.styleable.CustomSeekBar_csb_custom_color, mSecondTrackColor)
        mCustomTextSize =
            valueContext.getDimensionPixelSize(
                R.styleable.CustomSeekBar_csb_custom_text_size,
                sp2px(14)
            )
        mCustomTextColor =
            valueContext.getColor(R.styleable.CustomSeekBar_csb_custom_text_color, Color.WHITE)
        isShowSectionMark =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_show_section_mark, false)
        isAutoAdjustSectionMark =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_auto_adjust_section_mark, false)
        isShowProgressInFloat =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_show_progress_in_float, false)
        var duration = valueContext.getInteger(R.styleable.CustomSeekBar_csb_anim_duration, -1)
        mAnimDuration = if (duration < 0) 200 else duration.toLong()
        isTouchToSeek = valueContext.getBoolean(R.styleable.CustomSeekBar_csb_touch_to_seek, false)
        isAlwaysShowCustom =
            valueContext.getBoolean(R.styleable.CustomSeekBar_csb_always_show_custom, false)
        duration =
            valueContext.getInteger(R.styleable.CustomSeekBar_csb_always_show_custom_delay, 0)
        mAlwaysShowCustomDelay = if (duration < 0) 0 else duration.toLong()
        isHideCustom = valueContext.getBoolean(R.styleable.CustomSeekBar_csb_hide_custom, false)
        isRtl = valueContext.getBoolean(R.styleable.CustomSeekBar_csb_rtl, false)
        isEnabled = valueContext.getBoolean(R.styleable.CustomSeekBar_android_enabled, isEnabled)
        valueContext.recycle()

        mPaint = Paint()
        mPaint.apply {
            isAntiAlias = true
            strokeCap = Paint.Cap.ROUND
            textAlign = Paint.Align.CENTER
        }

        mRectText = Rect()
        mTextSpace = dp2px(2)

        //initConfigByPriority()

        mWindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
       /* mCustomView.setProgressText(
            if (isShowProgressInFloat) {
            getProgressFloat().toString()
        } else {
            getProgress().toString()
        })*/
    }

    fun getProgressFloat(): Float {
        return formatFloat(processProgress())
    }

    private fun processProgress(): Float {
        val progress = mProgress
        if (isSeekBySection && triggerSeekBySection) {
            val half = mSectionValue / 2
            if (isTouchToSeek) {
                if (progress == mMin || progress == mMax) {
                    return progress
                }
                var secValue: Float
                for (i in 0..mSectionCount) {
                    secValue = i * mSectionValue
                    if (secValue < progress && secValue + mSectionValue >= progress) {
                        return if (secValue + half > progress) {
                            secValue
                        } else {
                            secValue + mSectionValue
                        }
                    }
                }
            }
            return if (progress >= mPreSecValue) {
                if (progress >= mPreSecValue + half) {
                    mPreSecValue += mSectionValue
                    mPreSecValue
                } else {
                    mPreSecValue
                }
            } else {
                if (progress >= mPreSecValue - half) {
                    mPreSecValue
                } else {
                    mPreSecValue -= mSectionValue
                    mPreSecValue
                }
            }
        }
        return progress
    }

    private fun formatFloat(value: Float): Float {
        val bigDecimal = BigDecimal.valueOf(value.toDouble())
        return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).toFloat()
    }

    private inner class CustomView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int = 0
    ) : View(context, attrs, defStyle) {

        private var mCustomPaint = Paint()
        private var mCustomPath = Path()
        private var mRect = Rect()
        private var mRectF = Paint()
        private var mProgressText = ""
        private var mCustomRectF = RectF()

        init {
            mCustomPaint.apply {
                isAntiAlias = true
                textAlign = Paint.Align.CENTER
            }
        }

        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            setMeasuredDimension(3 * mCustomRadius, 3 * mCustomRadius)

            mCustomRectF.set(
                measuredWidth / 2F - mCustomRadius, 0F,
                measuredWidth / 2F + mCustomRadius, (2 * mCustomRadius).toFloat()
            )
        }


        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            mCustomPath.reset()
            val x0 = measuredWidth / 2F
            val y0 = measuredHeight - mCustomRadius / 3F
            mCustomPath.moveTo(x0, y0)
            val x1 = measuredWidth / 2f - sqrt(3.00) / 2f * mCustomRadius
            val y1 = 3 / 2f * mCustomRadius
            mCustomPath.quadTo(
                (x1 - dp2px(2)).toFloat(), y1 - dp2px(2), x1.toFloat(), y1
            )
            mCustomPath.arcTo(mCustomRectF, 150F, 240F)

            val x2 = measuredWidth / 2f + sqrt(3.0) / 2f * mCustomRadius
            mCustomPath.quadTo(
                (x2 + dp2px(2)).toFloat(), y1 - dp2px(2), x0, y0
            )
            mCustomPath.quadTo(
                (x2 + dp2px(2)).toFloat(), y1 - dp2px(2),
                x0, y0
            )
            mCustomPath.close()
            mCustomPaint.color = mCustomColor
            canvas!!.drawPath(mCustomPath, mCustomPaint)

            mCustomPaint.apply {
                textSize = mCustomTextSize.toFloat()
                color = mCustomTextColor
                getTextBounds(mProgressText, 0, mProgressText.length, mRect)
            }

            val fm: FontMetrics = mCustomPaint.getFontMetrics()
            val baseline: Float = mCustomRadius + (fm.descent - fm.ascent) / 2f - fm.descent
            canvas.drawText(mProgressText, measuredWidth / 2f, baseline, mCustomPaint)
        }

        fun setProgressText(progressText: String) {
            if (mProgressText != progressText) {
                mProgressText = progressText
                invalidate()
            }
        }
    }

    fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
    }

    fun sp2px(sp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, sp.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
    }
}