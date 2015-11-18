package br.com.criandojogosandroid.cap04ex02_primitivas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class RectActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint paint = new Paint();
        private Random rnd = new Random();

        public Tela(Context context) {
            super(context);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 1000; i++) {
                paint.setStrokeWidth(rnd.nextInt(5));
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                int left = rnd.nextInt(canvas.getWidth());
                int top = rnd.nextInt(canvas.getHeight());
                int right = rnd.nextInt(canvas.getWidth());
                int bottom = rnd.nextInt(canvas.getHeight());
                canvas.drawRect(new Rect(left, top, right, bottom), paint);
            }
            invalidate();
        }
    }
}
