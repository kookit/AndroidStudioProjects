package sg.edu.nus.clubmanagement.activity;

/**
 * Created by kooc on 6/3/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

public class AddFacilityActivity extends AppCompatActivity {
    private EditText etFacilityName, etFacilityDesc;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_facility);

        etFacilityName = (EditText) findViewById(R.id.et_facility_name);
        etFacilityDesc = (EditText) findViewById(R.id.et_facility_desc);

        Button btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (isValid()) {
                    App.club.addFacility(etFacilityName.getText().toString().trim(),
                            etFacilityDesc.getText().toString().trim());
                    Toast.makeText(AddFacilityActivity.this, getString(R.string.save_successful),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private boolean isValid() {
        boolean isValid = true;
        if (TextUtils.isEmpty(etFacilityName.getText().toString().trim())) {
            etFacilityName.setError(getString(R.string.fac_select_validation_msg));
            isValid = false;
        }
        if (TextUtils.isEmpty(etFacilityDesc.getText().toString().trim())) {
            etFacilityDesc.setError(getString(R.string.fac_select_validation_msg));
            isValid = false;
        }

        return isValid;
    }
}
