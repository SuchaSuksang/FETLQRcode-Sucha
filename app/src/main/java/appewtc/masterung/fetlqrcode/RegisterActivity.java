package appewtc.masterung.fetlqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Exclicit
    private EditText nameEditText, userEditText, passwordEditText;

    private ImageView imageView;
    private Button button;
    private String nameString,userString,passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialView();

//Controller
        controller();
    }  // Main Method

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }


    private void controller() {
        imageView.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtName);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText= (EditText) findViewById(R.id.edtPassword);
        imageView = (ImageView) findViewById(R.id.btnBack);
        button = (Button) findViewById(R.id.btnNewRegis);
    }

    @Override
    public void onClick(View v) {

        //For Back
        if (v == imageView){
            finish();;
        }

        //For Button
        if(v == button){
            //get value from editText
            nameString = nameEditText.getText().toString().trim();
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                //Have Space
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),getResources().getString(R.string.message_HaveSpace));


            } else {
                //No Space
                uploadValueToServer();

            }

        }

    }

    private void uploadValueToServer() {

        try {

            PostData postData =new PostData(this);
            postData.execute(nameString,userString,passwordString);
            String strResult = postData.get();
            Log.d("17MayV1","Result ==>" +strResult);

            if (Boolean.parseBoolean(strResult)) {
                finish();

            } else {
                Toast.makeText(RegisterActivity.this,"Can not Upload Value", Toast.LENGTH_SHORT).show();

            }



        } catch (Exception e) {
            Log.d("17MayV1", "e upload ==>" + e.toString());



        }
    }
} //Main Class
