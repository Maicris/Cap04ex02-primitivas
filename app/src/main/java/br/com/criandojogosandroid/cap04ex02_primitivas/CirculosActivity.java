package br.com.criandojogosandroid.cap04ex02_primitivas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class CirculosActivity extends AppCompatActivity {

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
        private int minRaio = 20;

        public Tela(Context context) {
            super(context);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 1000; i++) {
                paint.setColor(Color.argb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                int cx = rnd.nextInt(canvas.getWidth());
                int cy = rnd.nextInt(canvas.getHeight());
                int raio = minRaio + rnd.nextInt(50);
                canvas.drawCircle(cx, cy, raio, paint);
            }
            invalidate();
        }
    }
}
