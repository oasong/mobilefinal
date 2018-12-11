package th.ac.kmitl.a59070098.mobilefinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private TextView home_hello, home_text;
    private Button home_pro_btn, home_frd_btn, home_so_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        home_hello = findViewById(R.id.home_hello);
        home_text = findViewById(R.id.home_text);
        home_pro_btn = findViewById(R.id.home_pro_btn);
        home_frd_btn = findViewById(R.id.home_frd_btn);
        home_so_btn = findViewById(R.id.home_so_btn);

        //SharedPreference
        String name = mPreferences.getString(getString(R.string.name), "");

        home_hello.setText("Hello " + name);
        home_text.setText("This is my quote ");

        // Make link to Profile
        home_pro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Home.this, Profile.class);
                startActivity(intent1);
            }
        });
    }
}
