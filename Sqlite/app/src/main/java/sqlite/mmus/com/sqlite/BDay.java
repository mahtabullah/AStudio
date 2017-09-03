package sqlite.mmus.com.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BDay extends AppCompatActivity {
    EditText e;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bday);
        e = (EditText) findViewById(R.id.edittext);
        b = (Button) findViewById(R.id.updatedb);

        final int rec_pos = getIntent().getIntExtra("MyKey", 999);
       final MyDBFunctions mf = new MyDBFunctions(getApplicationContext());

        String t = mf.fetch_data(rec_pos + 1);
        e.setText(t);
        e.setSelection(e.getText().length());
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            mf.ubdate_birthday((rec_pos+1), e.getText().toString());
                Toast.makeText(BDay.this,"Database updated",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DataShow.class));
            }
        });
    }
}
