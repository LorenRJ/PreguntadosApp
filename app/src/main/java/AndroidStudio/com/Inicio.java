package AndroidStudio.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    private Button buton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        buton1 = findViewById(R.id.empezar);
        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                incioApp();
            }
        });
    }
    private void incioApp(){
        Intent intent = new Intent(Inicio.this,MainActivity.class);
        startActivity(intent);
    }
}