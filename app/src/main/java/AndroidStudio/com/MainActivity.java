package AndroidStudio.com;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import AndroidStudio.com.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;
import android.app.AlertDialog;
import android.content.DialogInterface;
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<Preguntas> preg = new ArrayList<>();
    public TextView text;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private String respuesta;
    private TextView acr;
    private TextView contpreg;
    private boolean verdad = true;
    private TextView tit;
    private ImageView famImg;
    private ImageView tutorial;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private int contador1 = 1;
    //private Bitmap cienciasImg = BitmapFactory.decodeFile(String.valueOf(R.drawable.quimica));
    public int acertados = 0;
    private int preguntas = 0;//Este contador debe de llegar a 20
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView1);
        boton1 = findViewById(R.id.button);
        boton2 = findViewById(R.id.button5);
        boton3 = findViewById(R.id.button6);
        boton4 = findViewById(R.id.button7);
        famImg = findViewById(R.id.family);
        famImg.setImageResource(R.drawable.quimica1);
        acr = findViewById(R.id.aciertos);
        contpreg = findViewById(R.id.contador);
        tit = findViewById(R.id.titulo);
        tutorial = findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Tutorial.class);
                startActivity(intent);
            }
        });
        contpreg.setText("Pregunta "+contador1);
        preguntas();
        inicializador();
    }
    private void inicioFin(){
            Intent intent = new Intent(MainActivity.this, Final.class);
            String r = String.valueOf(acertados);
            intent.putExtra("acertados",r);
            startActivity(intent);
            verdad = false;
    }
    private void inicioIni(){
        if(verdad == true){
            Intent intent = new Intent(MainActivity.this,Inicio.class);
            startActivity(intent);
            verdad = false;
        }

    }
    private void preguntas(){
        preg.clear();
        preg.add(new Preguntas("¿Cuantos años tiene el papa?","34","92","89","65","65","Ciencias"));
        preg.add(new Preguntas("¿Cuantos años lleva la tierra teniendo oxigeno?","10 millones de años","100 millones de año","50 millones de años","110 millones de año","100 millones de año","Ciencias"));
        preg.add(new Preguntas("¿Cuantos cantos tiene una hoja?","4","5","6","3","4","Ciencias"));
        preg.add(new Preguntas("¿Capital de España?","Berlin","Madrid","Londres","Ciudad de madrid","Madrid","Geografia"));
        preg.add(new Preguntas("¿Capital de Alemania?","Berlin","Madrid","Londres","Ciudad de madrid","Berlin","Geografia"));
        preg.add(new Preguntas("¿Capital de Ecuador?","Berlin","Madrid","Lima","Quito","Quito","Geografia"));
        preg.add(new Preguntas("¿Quien es el mejor mediocentro de la historia?","Ceballos","Xavi Hernández","Modric","Iniesta","Iniesta","Deportes"));
        preg.add(new Preguntas("¿Quien es el mejor tenista del mundo?","Rafael Nadal","Djocovic","David Ferrer","Federer","Rafael Nadal","Deportes"));
        preg.add(new Preguntas("¿Quien es el mejor delantero de la historia?","Cristiano Ronaldo","Lionel Messi","Robert Lewandowski","Ronaldinho","Cristiano Ronaldo","Deportes"));
        preg.add(new Preguntas("¿Cual es el pais mas pequeño del  mundo?","El Vaticano","Monaco","Luxemburgo","Andorra","El Vaticano","Geografia"));
        preg.add(new Preguntas("¿Evento que desencadeno la segunda guerra mundial?","Invasion alemana en Polonia","Asesinato del Archiduque Franz Ferdinand","Bomba atómica en Japón","Golpe de estado Español","Invasion alemana en Polonia","Historia"));
        preg.add(new Preguntas("¿Quién fue el líder soviético durante la Segunda Guerra Mundial?","Stalin","Churchill","Roosevelt","Hitler","Stalin","Historia"));
        preg.add(new Preguntas("¿Quién fue el fundador del Imperio Romano?","Julio Cesar","Augusto","Trajano","Nero","Julio Cesar","Historia"));
        preg.add(new Preguntas("¿Cuál fue el objetivo de la expedición de Cristóbal Colón?","Descubrir nueva ruta hacia Asia","Conquistar América","Fijar una colonia en el Caribe","Descubrir un nuevo continente","Descubrir nueva ruta hacia Asia","Historia"));
        preg.add(new Preguntas("¿Quién fue el fundador del Imperio Persa?","Alejandro Magno","Darío el Grande","Ciro el Grande","Jerjes I","Ciro el Grande","Historia"));
        preg.add(new Preguntas("¿Quién fue el principal autor del Manifiesto del Partido Comunista?","Friedrich Engels","Karl Marx","Vladimir Lenin","Joseph Stalin","Karl Marx","Historia"));
        preg.add(new Preguntas("¿Quién fundó la dinastía de los Reyes Católicos en España?","Los Reyes Católicos","Felipe II","Isabel y Fernando","Carlos V","Isabel y Fernando","Historia"));
        preg.add(new Preguntas("¿En qué año comenzó la Guerra Civil Española?","1936","1939","1942","1945","1936","Historia"));
    }

    private void comprobarImg(String familia){
        switch(familia){
            case"Geografia":
                famImg.setImageResource(R.drawable.geografia);
                tit.setTextColor(getColor(R.color.geografia));
                break;
            case"Ciencias":
                famImg.setImageResource(R.drawable.quimica1);
                tit.setTextColor(getColor(R.color.ciencia));
                break;
            case"Deportes":
                famImg.setImageResource(R.drawable.deportes);
                tit.setTextColor(getColor(R.color.deporte));
                break;
            case"Historia":
                tit.setTextColor(getColor(R.color.historia));
                famImg.setImageResource(R.drawable.historia);
                break;
        }
    }
    private void reset(){
        boton1.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        boton4.setEnabled(true);
        boton1.setBackgroundColor(getColor(R.color.purple_700));
        boton2.setBackgroundColor(getColor(R.color.purple_700));
        boton3.setBackgroundColor(getColor(R.color.purple_700));
        boton4.setBackgroundColor(getColor(R.color.purple_700));
    }
    private void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void sumatorio(){
        acertados = acertados + 1;
        acr.setText(String.valueOf(acertados));
    }
    private void inicializador(){
        if(preguntas== 5){
            inicioFin();
        }
        Random rand = new Random();
        int num = rand.nextInt(preg.size()-1);
        tit.setText(preg.get(num).getFamilia());
        text.setText(preg.get(num).getNombre());
        boton1.setText(preg.get(num).getRespuesta1());
        boton2.setText(preg.get(num).getRespuesta2());
        boton3.setText(preg.get(num).getRespuesta3());
        boton4.setText(preg.get(num).getRespuesta4());
        comprobarImg(preg.get(num).getFamilia());
        //Definimos respueta y eliminamos del array para que carguen preguntas nuevas.
        respuesta = preg.get(num).getResultado();
        preg.remove(num);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                if(boton1.getText() == respuesta){
                    boton1.setBackgroundColor(getColor(R.color.green));
                    //sleep();
                    alertV();
                }else{
                    boton1.setBackgroundColor(getColor(R.color.red));
                    //sleep();
                    alertM();
                }
                //reset();
                //inicializador();
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton1.setEnabled(false);
                boton3.setEnabled(false);
                boton4.setEnabled(false);
                if(boton2.getText() == respuesta){
                    boton2.setBackgroundColor(getColor(R.color.green));
                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //startActivity(intent);
                    alertV();
                }else{
                    boton2.setBackgroundColor(getColor(R.color.red));
                    alertM();
                }
                //sleep();
                //reset();
                //inicializador();
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton4.setEnabled(false);
                if(boton3.getText() == respuesta){
                    boton3.setBackgroundColor(getColor(R.color.green));
                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //startActivity(intent);
                    alertV();
                }else{
                    boton3.setBackgroundColor(getColor(R.color.red));
                    alertM();
                }
                //sleep();
                //reset();
                //inicializador();
                // Aqui escribiras el codigo que deseas ejecutar
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui escribiras el codigo que deseas ejecutar
                boton1.setEnabled(false);
                boton2.setEnabled(false);
                boton3.setEnabled(false);
                if(boton4.getText() == respuesta){
                    boton4.setBackgroundColor(getColor(R.color.green));
                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //startActivity(intent);
                    alertV();
                }else{
                    boton4.setBackgroundColor(getColor(R.color.red));
                    alertM();
                }
                //sleep();
                //reset();
                //inicializador();
            }
        });
    }
    private void alertM(){
        builder = new AlertDialog.Builder(this);
        // Establece el título y el mensaje del cuadro de diálogo
        builder.setTitle("");
        builder.setMessage("FALLASTE!");
        // Agrega un botón "Aceptar" al cuadro de diálogo
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Acción a realizar al presionar el botón "Aceptar"
                reset();
                preguntas = preguntas + 1;
                contador1 ++;
                contpreg.setText("Pregunta "+contador1);
                inicializador();
            }
        });
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getColor(R.color.red)));
        dialog.show();
    }
    private void alertV(){
        builder = new AlertDialog.Builder(this);
        // Establece el título y el mensaje del cuadro de diálogo
        builder.setTitle("");
        builder.setMessage("ACERTASTE");

        // Agrega un botón "Aceptar" al cuadro de diálogo
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Acción a realizar al presionar el botón "Aceptar"
                sumatorio();
                reset();
                contador1 ++;
                contpreg.setText("Pregunta "+contador1);
                preguntas = preguntas +1;
                inicializador();
            }
        });
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getColor(R.color.green)));
        dialog.show();
    }
}