package AndroidStudio.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Final extends AppCompatActivity {
    private TextView t;
    private Button send;
    private TextView resul;
    private MainActivity m = new MainActivity();
    private EditText email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        send = findViewById(R.id.send);
        t = findViewById(R.id.result);
        email1 = findViewById(R.id.editTextTextEmailAddress);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("acertados") != null) {
            t.setText(String.valueOf(bundle.getString("acertados")));
        }
        sendEmail();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                String email = email1.getText().toString().trim();;
                String subject = "Informe";
                String message = "Has acertado tantas preguntas";
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties props = System.getProperties();
                //SendMail sm = new SendMail(this, email, subject, message);
                Log.e("ESTAMOS EN EL MANDAREMAIL", "ESTAMOS EN EL MANDAREMAIL PERO ARRIBA");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.user", email);
                props.put("mail.smtp.clave", "ixjzdxnlnxstsobi");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.port", "587");
                Session session = Session.getDefaultInstance(props);
                MimeMessage mm = new MimeMessage(session);

                mm.setFrom(new InternetAddress("pregstarsgerencia@gmail.com"));
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                mm.setSubject(subject);
                mm.setText(message);

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", email, "ixjzdxnlnxstsobi");
                transport.sendMessage(mm, mm.getAllRecipients());
                transport.close();
                Log.e("ESTAMOS EN EL MANDAREMAIL", "ESTAMOS EN EL MANDAREMAIL");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }
}