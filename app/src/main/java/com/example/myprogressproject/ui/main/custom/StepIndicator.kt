package com.example.myprogressproject.ui.main.custom

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.myprogressproject.R


class StepIndicator : View {

    var radius: Int = 0
    private var mLineHeight: Float = 0.toFloat()
    private var strokeWidth: Int = 0
    private var currentStepPosition: Int = 0
    private var stepsCount = 1
    private var dotSpacing = 0
    private var bgColor: Int = 0
    private var stepColor: Int = 0
    private var currentColor: Int = 0

    private var pointY: Int = 0
    private var startX: Int = 0
    private var endX: Int = 0
    private var stepDistance: Int = 0

    private var paint: Paint? = null
    private var pStoke: Paint? = null
    private val hsvCurrent = FloatArray(3)
    private val hsvBG = FloatArray(3)
    private val hsvProgress = FloatArray(3)

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {

        initAttributes(context, attributeSet)

        paint = Paint()
        pStoke = Paint()

        paint!!.color = stepColor
        paint!!.flags = Paint.ANTI_ALIAS_FLAG
        paint!!.strokeWidth = mLineHeight

        pStoke!!.color = stepColor
        pStoke!!.strokeWidth = strokeWidth.toFloat()
        pStoke!!.style = Paint.Style.STROKE
        pStoke!!.flags = Paint.ANTI_ALIAS_FLAG

        minimumHeight = radius * 2
        Color.colorToHSV(currentColor, hsvCurrent)
        Color.colorToHSV(bgColor, hsvBG)
        Color.colorToHSV(stepColor, hsvProgress)
        invalidate()
    }

    private fun initAttributes(context: Context, attributeSet: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.StepView, 0, 0)

        try {
            radius =
                attr.getDimension(R.styleable.StepView_svRadius, dp2px(DEFAULT_STEP_RADIUS.toFloat())).toInt()
            strokeWidth =
                attr.getDimension(R.styleable.StepView_svStrokeWidth, dp2px(DEFAULT_STOKE_WIDTH.toFloat()))
                    .toInt()
            stepsCount = attr.getInt(R.styleable.StepView_svStepCount, DEFAULT_STEP_COUNT)
            dotSpacing = attr.getDimension(R.styleable.StepView_svDotSpacing, dp2px(8f)).toInt()
            mLineHeight = attr.getDimension(R.styleable.StepView_svLineHeight, DEFAULT_LINE_HEIGHT)
            stepColor = attr.getColor(
                R.styleable.StepView_svStepColor,
                ContextCompat.getColor(context, DEFAULT_STEP_COLOR)
            )
            currentColor = attr.getColor(
                R.styleable.StepView_svCurrentStepColor,
                ContextCompat.getColor(context, DEFAULT_CURRENT_STEP_COLOR)
            )
            bgColor = attr.getColor(
                R.styleable.StepView_svBackgroundColor,
                ContextCompat.getColor(context, DEFAULT_BACKGROUND_COLOR)
            )
        } finally {
            attr.recycle()
        }
    }

    private fun dp2px(dp: Float): Float {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(dp * (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)).toFloat()
    }

    fun getStepsCount(): Int {
        return stepsCount
    }

    fun setStepsCount(stepsCount: Int) {
        this.stepsCount = stepsCount
        invalidate()
    }

    fun getDotSpacing(): Int {
        return dotSpacing
    }

    fun setDotSpacing(dotSpacing: Int) {
        this.dotSpacing = dotSpacing
        invalidate()
    }

    fun getCurrentStepPosition(): Int {
        return currentStepPosition
    }

    fun setCurrentStepPosition(currentStepPosition: Int) {
        if (currentStepPosition <= stepsCount) {
            this.currentStepPosition = currentStepPosition
        }
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        if (stepsCount <= 1) {
            visibility = GONE
            return
        }
        super.onDraw(canvas)

        /**draw Circle  */
        var pointX: Int = (width - ((stepsCount*(radius*2))+(stepsCount-1)*dotSpacing))/2+radius
        for (i in 0 until stepsCount) {
            if (i < currentStepPosition) {
                //draw previous step
                paint!!.color = stepColor
                canvas.drawCircle(pointX.toFloat(), pointY.toFloat(), radius.toFloat(), paint!!)
            } else {
                //draw next step
                paint!!.color = bgColor
                canvas.drawCircle(pointX.toFloat(), pointY.toFloat(), radius.toFloat(), paint!!)
            }
            pointX += radius*2+dotSpacing
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        pointY = height / 2
        startX = radius * 2
        endX = width - radius * 2
        stepDistance = (endX - startX) / (stepsCount - 1)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        setMeasuredDimension(
            measureDimension(desiredWidth, widthMeasureSpec),
            measureDimension(desiredHeight, heightMeasureSpec)
        )

        pointY = height / 2

        startX = radius * 2
        endX = width - radius * 2
        stepDistance = (endX - startX) / (stepsCount - 1)
    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = desiredSize
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize)
            }
        }

        if (result < desiredSize) {
            Log.e("StepView", "The view is too small, the content might get cut")
        }
        return result
    }

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()
        val ss = superState?.let { SavedState(it) }
        ss?.mLineHeight = this.mLineHeight
        ss?.radius = this.radius
        ss?.strokeWidth = this.strokeWidth
        ss?.currentStepPosition = this.currentStepPosition
        ss?.stepsCount = this.stepsCount
        ss?.dotSpacing = this.dotSpacing
        ss?.backgroundColor = this.bgColor
        ss?.stepColor = this.stepColor
        ss?.currentColor = this.currentColor
        return ss
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        if (state !is SavedState) {
            super.onRestoreInstanceState(state)
            return
        }

        super.onRestoreInstanceState(state.superState)
        this.mLineHeight = state.mLineHeight
        this.radius = state.radius
        this.strokeWidth = state.strokeWidth
        this.currentStepPosition = state.currentStepPosition
        this.stepsCount = state.stepsCount
        this.dotSpacing = state.dotSpacing
        this.bgColor = state.backgroundColor
        this.stepColor = state.stepColor
        this.currentColor = state.currentColor
    }

    internal class SavedState : BaseSavedState {
        var radius: Int = 0
        var mLineHeight: Float = 0.toFloat()
        var strokeWidth: Int = 0
        var currentStepPosition: Int = 0
        var stepsCount: Int = 0
        var dotSpacing: Int = 0
        var backgroundColor: Int = 0
        var stepColor: Int = 0
        var currentColor: Int = 0
        var pageStrokeAlpha: Int = 0

        constructor(superState: Parcelable) : super(superState)

        private constructor(`in`: Parcel) : super(`in`) {
            mLineHeight = `in`.readFloat()
            radius = `in`.readInt()
            strokeWidth = `in`.readInt()
            currentStepPosition = `in`.readInt()
            stepsCount = `in`.readInt()
            dotSpacing = `in`.readInt()
            backgroundColor = `in`.readInt()
            stepColor = `in`.readInt()
            currentColor = `in`.readInt()
            pageStrokeAlpha = `in`.readInt()
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            super.writeToParcel(dest, flags)
            dest.writeFloat(mLineHeight)
            dest.writeInt(radius)
            dest.writeInt(strokeWidth)
            dest.writeInt(currentStepPosition)
            dest.writeInt(stepsCount)
            dest.writeInt(dotSpacing)
            dest.writeInt(backgroundColor)
            dest.writeInt(stepColor)
            dest.writeInt(currentColor)
            dest.writeInt(pageStrokeAlpha)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<SavedState> = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(`in`: Parcel): SavedState {
                    return SavedState(`in`)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }

    companion object {
        private const val DEFAULT_STEP_RADIUS = 10   //DP
        private const val DEFAULT_STOKE_WIDTH = 6  //DP
        private const val DEFAULT_STEP_COUNT = 4  //DP
        private const val DEFAULT_BACKGROUND_COLOR = R.color.step_indicator_inactive
        private const val DEFAULT_STEP_COLOR = R.color.step_indicator_active
        private const val DEFAULT_CURRENT_STEP_COLOR = R.color.step_indicator_active
        const val DEFAULT_LINE_HEIGHT = 6.0f
        const val DEFAULT_STROKE_ALPHA = 100
    }
}