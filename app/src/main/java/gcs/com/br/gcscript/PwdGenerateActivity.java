package gcs.com.br.gcscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gcs.com.br.gcscript.lib.GCSCriptUtils;
import gcs.com.br.gcscript.lib.GCSLoginUtils;

public class PwdGenerateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_generate);

        setEvents();
    }

    private void setEvents() {
        Button btnLogin = (Button)findViewById(R.id.btnPwdGenerate);
        Button btnExit = (Button)findViewById(R.id.btnPwdGenerateExit);

        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText edtP = (EditText)findViewById(R.id.edtPwdGeneratePassword);
                    EditText edtRP = (EditText)findViewById(R.id.edtPwdGeneratePasswordRetype);

                    if (!edtP.getText().toString().equals(edtRP.getText().toString()))
                        GCSCriptUtils.showToast(PwdGenerateActivity.this,
                                "As senhas não conferem, tente novamente!");

                    if (GCSLoginUtils.loginSave(PwdGenerateActivity.this, edtP.getText().toString()))
                        finish();
                }
            });
        }

        if (btnExit != null) {
            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
