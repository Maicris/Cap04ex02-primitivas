package br.com.criandojogosandroid.cap04ex02_primitivas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class PontosActivity extends AppCompatActivity {

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
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 10000; i++) {
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                int x = rnd.nextInt(canvas.getWidth());
                int y = rnd.nextInt(canvas.getHeight());
                canvas.drawPoint(x, y, paint);
            }
            invalidate();
        }
    }
}
