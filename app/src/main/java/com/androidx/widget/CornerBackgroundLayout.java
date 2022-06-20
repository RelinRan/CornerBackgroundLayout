package com.androidx.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * 缺角RelativeLayout<br/>
 * 主要对四个角进行圆角挖空处理。<br/>
 */
public class CornerBackgroundLayout extends RelativeLayout {

    /**
     * 背景
     */
    private int solid = Color.parseColor("#0A4CFE");
    /**
     * 缺角半径
     */
    private float lackRadius = -1;
    /**
     * 左上 - 缺角半径
     */
    private float leftTopLackRadius = 0;
    /**
     * 左下 - 缺角半径
     */
    private float leftBottomLackRadius = 0;
    /**
     * 右上 - 缺角半径
     */
    private float rightTopLackRadius = 0;
    /**
     * 右下 - 缺角半径
     */
    private float rightBottomLackRadius = 0;
    /**
     * 矩形 - 半径
     */
    private float radius = density(8);

    public CornerBackgroundLayout(@NonNull Context context) {
        super(context);
        initAttributeSet(context, null);
    }

    public CornerBackgroundLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(context, attrs);
    }

    public CornerBackgroundLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(context, attrs);
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CornerBackgroundLayout);
            solid = array.getColor(R.styleable.CornerBackgroundLayout_solid, solid);
            lackRadius = array.getDimension(R.styleable.CornerBackgroundLayout_lackRadius, lackRadius);
            leftTopLackRadius = array.getDimension(R.styleable.CornerBackgroundLayout_leftTopLackRadius, leftTopLackRadius);
            leftBottomLackRadius = array.getDimension(R.styleable.CornerBackgroundLayout_leftBottomLackRadius, leftBottomLackRadius);
            rightTopLackRadius = array.getDimension(R.styleable.CornerBackgroundLayout_rightTopLackRadius, rightTopLackRadius);
            rightBottomLackRadius = array.getDimension(R.styleable.CornerBackgroundLayout_rightBottomLackRadius, rightBottomLackRadius);
            if (lackRadius != -1) {
                leftTopLackRadius = leftBottomLackRadius = rightTopLackRadius = rightBottomLackRadius = lackRadius;
            }
            array.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Bitmap bitmap = makeLackBitmap(getMeasuredWidth(), getMeasuredHeight(), radius, new float[]{leftTopLackRadius, leftBottomLackRadius, rightTopLackRadius, rightBottomLackRadius});
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        setBackground(drawable);
    }

    protected float density(int value) {
        return Resources.getSystem().getDisplayMetrics().density * value;
    }

    /**
     * 获取缺角Bitmap
     *
     * @param width      宽度
     * @param height     高度
     * @param radius     矩形圆角
     * @param lackRadius 缺角圆角
     * @return
     */
    protected Bitmap makeLackBitmap(int width, int height, float radius, float lackRadius[]) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(solid);
        RectF rectF = new RectF(0, 0, width, height);
        canvas.drawRoundRect(rectF, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        paint.setColor(Color.TRANSPARENT);
        //左上
        if (lackRadius.length > 0) {
            canvas.drawCircle(0, 0, lackRadius[0], paint);
        }
        //左下
        if (lackRadius.length > 1) {
            canvas.drawCircle(0, height, lackRadius[1], paint);
        }
        //右上
        if (lackRadius.length > 2) {
            canvas.drawCircle(width, 0, lackRadius[2], paint);
        }
        //右下
        if (lackRadius.length > 3) {
            canvas.drawCircle(width, height, lackRadius[3], paint);
        }
        return bitmap;
    }

    public void setSolid(int solid) {
        this.solid = solid;
        invalidate();
    }

    /**
     * 设置矩形半径
     *
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    /**
     * 设置缺角半径
     *
     * @param lackRadius
     */
    public void setLackRadius(float lackRadius) {
        this.lackRadius = lackRadius;
        leftTopLackRadius = leftBottomLackRadius = rightTopLackRadius = rightBottomLackRadius = lackRadius;
        invalidate();
    }

    /**
     * 设置左上 - 缺角半径
     *
     * @param leftTopLackRadius 左上 - 缺角半径
     */
    public void setLeftTopLackRadius(float leftTopLackRadius) {
        this.leftTopLackRadius = leftTopLackRadius;
        invalidate();
    }

    /**
     * 设置左下 - 缺角半径
     *
     * @param leftBottomLackRadius 左下 - 缺角半径
     */
    public void setLeftBottomLackRadius(float leftBottomLackRadius) {
        this.leftBottomLackRadius = leftBottomLackRadius;
        invalidate();
    }

    /**
     * 设置右上 - 缺角半径
     *
     * @param rightTopLackRadius 右上 - 缺角半径
     */
    public void setRightTopLackRadius(float rightTopLackRadius) {
        this.rightTopLackRadius = rightTopLackRadius;
        invalidate();
    }

    /**
     * 设置右下 - 缺角半径
     *
     * @param rightBottomLackRadius 右下 - 缺角半径
     */
    public void setRightBottomLackRadius(float rightBottomLackRadius) {
        this.rightBottomLackRadius = rightBottomLackRadius;
        invalidate();
    }

}