package th.ac.kmitl.a59070098.mobilefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    private EditText profile_id, profile_name, profile_age, profile_password, profile_text;
    private Button profile_save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_id = findViewById(R.id.profile_id);
        profile_name = findViewById(R.id.profile_name);
        profile_age = findViewById(R.id.profile_age);
        profile_password = findViewById(R.id.profile_password);
        profile_text = findViewById(R.id.profile_text);
        profile_save_btn = findViewById(R.id.profile_save_btn);


    }
}
