package br.com.criandojogosandroid.cap04ex02_primitivas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class OvalActivity extends AppCompatActivity {

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
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(1);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float raio = canvas.getHeight() / 10.0f;
            for (int i = 0; i < 10; i++) {
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                float left = 0;
                float top = i * raio;
                float right = canvas.getWidth();
                float bottom = i * raio + raio;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    canvas.drawOval(left, top, right, bottom, paint);
                }
                invalidate();
            }
        }
    }
}
