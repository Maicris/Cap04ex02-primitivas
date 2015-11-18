package br.com.criandojogosandroid.cap04ex02_primitivas;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String items[] = {
                "Desenhando Pontos",
                "Desenhando Linhas",
                "Desenhando Círculos",
                "Desenhando Retângulos",
                "Desenhando Retângulos com Bordas Arredondadas",
                "Desenhando Ovais",
                "Desenhando Arcos"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(new Intent(this, PontosActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, LinhasActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, CirculosActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, RectActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, RoundRectActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, OvalActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, ArcActivity.class));
                break;
        }
    }
}
