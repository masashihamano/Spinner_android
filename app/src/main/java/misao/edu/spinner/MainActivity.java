package misao.edu.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1,spinner2,spinner3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        spinner1 = findViewById( R.id.spinner1 );
        spinner2 = findViewById( R.id.spinner2 );
        spinner3 = findViewById( R.id.spinner3 );

        String country[] = {"Japan","Denmark","Djibouti","Dominica","Egypt","France","Finland","Fiji","Eritrea","Estonia","Ethiopia"};

        String number[] = {"170.1","170.2","170.3","170.4","170.5","171.0","171.1","171.2","171.3","171.4","171.5","172.0","172.1","172.2"};

        String blood[] = {"A","B","O","AB"};


        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>( this,android.R.layout.simple_spinner_item,country );
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>( this,android.R.layout.simple_spinner_item,number );

        arrayAdapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        arrayAdapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner1.setAdapter( arrayAdapter1 );
        spinner2.setAdapter( arrayAdapter2 );

        spinner1.setOnItemSelectedListener( this );
        spinner2.setOnItemSelectedListener( this );


        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>( this,android.R.layout.simple_spinner_item,blood );
        arrayAdapter3.setDropDownViewResource( android.R.layout.simple_spinner_item );
        spinner3.setAdapter( arrayAdapter3 );
        spinner3.setOnItemSelectedListener( this );

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        String item = adapterView.getItemAtPosition( position ).toString();

        Toast.makeText( this, ""+item, Toast.LENGTH_SHORT ).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


/*
main.xmlにTextViewとSpinnerを設置
MainActivity.javaにspinnerを宣言、初期化
データ(配列)を準備
ArrayAdapterを<String>でインスタンス化し、準備したデータをandroid.R.layout.simple_spinner_itemに指定
ArrayAdapterをDropDownViewResourceにsetし、setOnItemSelectedListenerを@Overrideする
intをposition、longをidに指定し、Stringで格納
onNothingSelectedはspinnerを閉じるコードなので何も書かない

 */