package gcs.com.br.gcscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gcs.com.br.gcscript.lib.GCSCriptUtils;
import gcs.com.br.gcscript.lib.GCSLoginUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verifyMasterPwd();
        setEvents();
    }

    private void verifyMasterPwd() {
        GCSLoginUtils.removeMasterPwd(this);
        String p = GCSLoginUtils.getMasterPwd(this);

        if (p == "") {
            p = GCSLoginUtils.setMasterPwd(this);
            GCSCriptUtils.openYESNOMessage(this,
                    getString(R.string.masterPwdMessageGenerated) + "\n" + p,
                    null, null);
        }
    }

    private void setEvents() {
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        Button btnExit = (Button)findViewById(R.id.btnLoginExit);

        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText edtP = (EditText)findViewById(R.id.edtLoginPassword);

                    if (GCSLoginUtils.login(LoginActivity.this, edtP.getText().toString()))
                        GCSCriptUtils.openActivity(LoginActivity.this,
                                CriptActivity.class);
                    else
                        GCSCriptUtils.showToast(LoginActivity.this,
                                "Não foi possível realizar o login, usuário e/ou senha inválidos");
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
