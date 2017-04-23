package gcs.com.br.gcscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gcs.com.br.gcscript.lib.GCSCriptUtils;

public class DecriptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decript);

        setEvents();
    }

    private void setEvents() {
        Button btnDecript = (Button)findViewById(R.id.btnDecriptDecript);
        Button btnBack = (Button)findViewById(R.id.btnDecriptBack);

        if (btnDecript != null) {
            btnDecript.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText edtNormal = (EditText) findViewById(R.id.edtDecriptNormalText);
                    EditText edtCripted = (EditText) findViewById(R.id.edtDescriptCriptedText);

                    edtNormal.setText(GCSCriptUtils.decript(edtCripted.getText().toString()));
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
