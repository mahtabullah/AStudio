package listview.mmus.com.listview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.lvid);
        final String[] SKU ={"Pepsi","7UP","Orange","DEW"};
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.lvlayout,R.id.txtid,SKU);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(getApplicationContext(),"Clicked on "+SKU[position], LENGTH_LONG).show();

                AlertDialog.Builder mybilder=new AlertDialog.Builder(MainActivity.this);
                mybilder.setTitle("Attation");
                mybilder.setMessage("You Clicked on "+SKU[position]);
                mybilder.setIcon(R.drawable.pepsi);
                mybilder.setPositiveButton("Yes,Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Clicked  yes ", LENGTH_SHORT).show();
                    }
                });
                mybilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Clicked  No ", LENGTH_SHORT).show();
                    }
                });
                AlertDialog mydialog=mybilder.create();
                mydialog.show();

            }
        });
    }
}
