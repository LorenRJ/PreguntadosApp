package AndroidStudio.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tutorial extends AppCompatActivity {
    private ImageView salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        salir = findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Tutorial.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}