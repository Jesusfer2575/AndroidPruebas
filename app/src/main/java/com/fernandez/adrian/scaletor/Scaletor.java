package com.fernandez.adrian.scaletor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Scaletor extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private TextView tv_result;
    private Button bt_mayor;
    private Button bt_menor_melodica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaletor);

        this.bt_mayor = (Button) findViewById(R.id.btn_mayor);
        this.bt_mayor.setOnClickListener(this);

        this.bt_menor_melodica = (Button) findViewById(R.id.btn_menor_melodica);
        this.bt_menor_melodica.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.intervalos_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch(id){
            case R.id.opuno:
                Intent it1 = new Intent(Scaletor.this, Mayor.class);
                startActivity(it1);
                break;
            case R.id.opdos:
                Intent it = new Intent(Scaletor.this, MenorMelodica.class);
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        //El switch se utiliza para diferencias un botón de otro en casa de que existiera más de uno en el layout
        switch(v.getId()){
            case R.id.btn_mayor:
                Intent it1 = new Intent(Scaletor.this, Mayor.class);
                startActivity(it1);
                break;
            case R.id.btn_menor_melodica:
                Intent it = new Intent(Scaletor.this, MenorMelodica.class);
                startActivity(it);
                break;
        }
    }
}
