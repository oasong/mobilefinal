package th.ac.kmitl.a59070098.mobilefinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText login_id, login_password;
    private Button login_btn;
    private TextView login_register;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    DatabaseHelperLogin helper = new DatabaseHelperLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        login_id = findViewById(R.id.login_id);
        login_password = findViewById(R.id.login_password);
        login_btn = findViewById(R.id.login_btn);
        login_register = findViewById(R.id.login_register);

        // Make link to Register
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        // Make Login Button
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = login_id.getText().toString();
                String password = login_password.getText().toString();


                if (id.isEmpty() || password.isEmpty()){
                    toastMessage("Please fill out this form");
                }else{
                    String checkPassword = helper.searchPassword(id);
                    if (password.equals(checkPassword)){
                        // Get item From SQLite
                        Cursor data = helper.getItemName(id);
                        String name = "";
                        while (data.moveToNext()){
                            name = data.getString(0);
                        }
                        Log.d("Check name","name = " + name);

                        Cursor data1 = helper.getItemAge(id);
                        int age = 0;
                        while (data.moveToNext()){
                            age = data.getInt(0);
                        }

//                        Cursor data2 = helper.getItemText(id);
//                        String text = "";
//                        while (data.moveToNext()){
//                            text = data.getString(0);
//                        }


                        // SharePreference
                        mEditor.putString(getString(R.string.name), name);
                        mEditor.commit();

                        mEditor.putString(getString(R.string.id_name), id);
                        mEditor.commit();

                        mEditor.putString(getString(R.string.password), password);
                        mEditor.commit();

                        mEditor.putInt(getString(R.string.age), age);
                        mEditor.commit();

                        mEditor.putString(getString(R.string.text), "My quote");
                        mEditor.commit();


//                        mEditor.putString(getString(R.string.text), text);
//                        mEditor.commit();

                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                    }else{
                        toastMessage("Invalid User Or Password");
                    }
                }


            }
        });
    }

    private void toastMessage(String m){
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }


}
