package gcs.com.br.gcscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gcs.com.br.gcscript.lib.GCSCriptUtils;

public class CriptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cript);

        setEvents();
    }

    private void setEvents() {
        Button btnCript = (Button)findViewById(R.id.btnCriptCript);
        Button btnBack = (Button)findViewById(R.id.btnCriptBack);

        if (btnCript != null) {
            btnCript.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText edtNormal = (EditText) findViewById(R.id.edtCriptNormalText);
                    EditText edtCripted = (EditText) findViewById(R.id.edtCriptCriptedText);

                    edtCripted.setText(GCSCriptUtils.cript(edtNormal.getText().toString()));
                }
            });
        }

        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
