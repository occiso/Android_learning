package example.jose.myappjose;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnEvent();

    }

    private void btnEvent(){
        findViewById(R.id.btnWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWeb();
            }
        });
        findViewById(R.id.btnSms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSms();
            }
        });
        findViewById(R.id.btnLlamar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTlf();
            }
        });
        findViewById(R.id.btnSmsAlternativo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSmsAlternative();
            }
        });
    }

    /**
     * URI de cualquier recurso, una web, imagen, teléfono.
     * ejemplos:
     * http://developer.android.com
     * tel://123456
     */
    protected void launchWeb(){
        try {
            String url = ((EditText)findViewById(R.id.etxUrl)).getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }catch (ActivityNotFoundException e){
            String msgError = getResources().getString(R.string.webError);//strings.xml
            ((EditText) findViewById( R.id.etxUrl)).setError(msgError);
        }
    }

    protected void launchTlf(){
        try {
            String telefono = ((EditText) findViewById(R.id.etTelefono)).getText().toString();
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
            startActivity(i);

        }catch (ActivityNotFoundException e){
                String msgError = getResources().getString(R.string.webError);//strings.xml
                ((EditText) findViewById(R.id.etTelefono)).setError(msgError);
        }
    }

    protected  void launchSms(){
        try{
            String telefono = ((EditText) findViewById(R.id.etTelefono)).getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telefono));
            i.putExtra("sms_body", "Cuerpo del mensaje del sms");
            startActivity(i);

        }catch (ActivityNotFoundException e){
            String msgError = getResources().getString(R.string.webError);//strings.xml
            ((EditText) findViewById(R.id.etTelefono)).setError(msgError);
        }
    }

    protected void launchSmsAlternative(){
        String telefono = ((EditText) findViewById(R.id.etTelefono)).getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.putExtra("address", telefono);
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("sms_body", "cuerpo del mensaje");
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
