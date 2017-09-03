package sqlite.mmus.com.sqlite;

        import android.content.Intent;
        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class DataShow extends AppCompatActivity {
 ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        lv=(ListView) findViewById(R.id.birthday);
        MyDBFunctions mf=new MyDBFunctions(getApplicationContext());
        String[] data=mf.my_data();
        lv.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.lview,R.id.txtid,data));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),BDay.class);
                i.putExtra("MyKey",position);
                startActivity(i);

            }
        });


    }
}
