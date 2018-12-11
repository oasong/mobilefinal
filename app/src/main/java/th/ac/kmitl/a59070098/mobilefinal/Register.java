package th.ac.kmitl.a59070098.mobilefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelperLogin helper = new DatabaseHelperLogin(this);

    EditText reg_id, reg_name, reg_age, reg_password;
    Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_id = findViewById(R.id.reg_id);
        reg_name = findViewById(R.id.reg_name);
        reg_age = findViewById(R.id.reg_age);
        reg_password = findViewById(R.id.reg_password);
        reg_btn = findViewById(R.id.reg_btn);

        // Make Onclick reg_btn
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = reg_id.getText().toString();
                String name = reg_name.getText().toString();
                String age = reg_age.getText().toString();
                String password = reg_password.getText().toString();

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

                                helper.insertContact(contact);
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
