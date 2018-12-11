package th.ac.kmitl.a59070098.mobilefinal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    DatabaseHelperLogin helper = new DatabaseHelperLogin(this);

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText profile_id, profile_name, profile_age, profile_password, profile_text;
    private Button profile_save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        profile_id = findViewById(R.id.profile_id);
        profile_name = findViewById(R.id.profile_name);
        profile_age = findViewById(R.id.profile_age);
        profile_password = findViewById(R.id.profile_password);
        profile_text = findViewById(R.id.profile_text);
        profile_save_btn = findViewById(R.id.profile_save_btn);

        // SharedPreferecnce
        profile_id.setText(mPreferences.getString(getString(R.string.id_name), ""));
        profile_name.setText(mPreferences.getString(getString(R.string.name), ""));
//        profile_age.setText(mPreferences.getString(getString(R.string.age), ""));
        profile_password.setText(mPreferences.getString(getString(R.string.password), ""));
        profile_text.setText(mPreferences.getString(getString(R.string.text), ""));

        // Make save button
        profile_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = profile_id.getText().toString();
                String name = profile_name.getText().toString();
                String age = profile_age.getText().toString();
                String password = profile_password.getText().toString();
                String protext = profile_text.getText().toString();

                if ( id.isEmpty() || name.isEmpty() || password.isEmpty() || age.isEmpty() ){
                    toastMessage("Fill in information");
                }else{
                    if (id.length() >= 6 && id.length() <= 12){
                        int intage = Integer.parseInt(age);
                        if (intage >= 10 && intage <= 80){
                            if (password.length() > 6){
                                Contact contact = new Contact();
                                contact.setId(id);
                                contact.setName(name);
                                contact.setAge(1);
                                contact.setPassword(password);

//                                helper.insertContact(contact);
                                toastMessage("Registered");
                            }else{
                                toastMessage("Password must be > 6 Characters");
                            }
                        }else{
                            toastMessage("Age must be > 9 and < 81");
                        }
                    }else{
                        toastMessage("Id must be > 5 and < 13 characters");
                    }
                }
            }
        });


    }

    private void toastMessage(String m){
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }
}
