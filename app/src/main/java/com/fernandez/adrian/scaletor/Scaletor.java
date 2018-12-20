package com.fernandez.adrian.scaletor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scaletor extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private TextView tv_result;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaletor);

        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        this.tv_result = (TextView) findViewById(R.id.Text_result);
        //tv.setText(stringFromJNI());
        this.tv_result.setText("Seleccione una opción");
        this.bt = (Button) findViewById(R.id.button);

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
                tv_result.setText("Escala Mayor");
                break;
            case R.id.opdos:
                tv_result.setText("Escala Menor Melódica");
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
            case R.id.button:
                break;
        }
    }
}
