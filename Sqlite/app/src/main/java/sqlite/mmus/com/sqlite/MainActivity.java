package sqlite.mmus.com.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.dob);
        b1 = (Button) findViewById(R.id.save);
        b2 = (Button) findViewById(R.id.show);
        final MyDBFunctions mf = new MyDBFunctions(getApplicationContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = e1.getText().toString();
                String _dob = e2.getText().toString();

                DataTemp dt=new DataTemp(_name,_dob);
                mf.addingDataTotable(dt);
                Toast.makeText(getApplicationContext(),_name + " " + _dob, Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), DataShow.class));
            }
        });
    }
}
