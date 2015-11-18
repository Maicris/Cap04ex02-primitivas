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

public class ArcActivity extends AppCompatActivity {

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
        private float distX, distY;

        public Tela(Context context) {
            super(context);
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            distX = (canvas.getWidth() / 2) / 10.0f;
            distY = (canvas.getHeight() / 2) / 10.0f;
            for (int i = 1; i < 10; i++) {
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                float left = distX * i;
                float top = distY * i;
                float right = canvas.getWidth() - distX*i;
                float bottom = canvas.getHeight() - distY*i;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    canvas.drawArc(left, top, right, bottom, 180, 90, false, paint);
                    canvas.drawArc(left, top, right, bottom, 0, 90, false, paint);
                }
            }
            invalidate();
        }
    }
}
