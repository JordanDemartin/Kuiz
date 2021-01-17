package com.example.kuiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class BarreProgressionQuiz extends View {

    private Paint bar_paint[];
    private Paint border_paint;
    private int height;

    public BarreProgressionQuiz(Context context, int nb_questions, RelativeLayout parent, int height) {
        super(context);
        this.bar_paint = new Paint[nb_questions];
        this.height = height;

        for(int i = 0 ; i < nb_questions ; i++){
            this.bar_paint[i] = new Paint();
            this.bar_paint[i].setARGB(255,255,255,255);
        }

        this.border_paint = new Paint();
        this.border_paint.setStyle(Paint.Style.STROKE);
        this.border_paint.setARGB(255,0,0,0);
        this.border_paint.setStrokeWidth(10);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
        parent.addView(this,layoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0 ; i < bar_paint.length ; i++){
            canvas.drawRect(( (getWidth()) /bar_paint.length)*i,0,( (getWidth()) /bar_paint.length)*(i+1),height,bar_paint[i]);
            canvas.drawRect(( (getWidth()) /bar_paint.length)*i,0,( (getWidth()) /bar_paint.length)*(i+1),height,border_paint);
        }
    }

    protected void changePaint(int num_question, int color){
        bar_paint[num_question].setColor(color);
        invalidate();
    }
}
