package co.edu.udea.compumovil.gr06_20181.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlatesActivity extends AppCompatActivity {

    private ImageButton ibPlateAddPhoto;
    private EditText etPlateName;
    private EditText etPlatePrice;
    private CheckBox cbPlateMorning;
    private CheckBox cbPlateAfternoon;
    private CheckBox cbPlateNight;
    private RadioButton rbPlateEntrance;
    private RadioButton rbPlateMain;
    private EditText etPlateIngredients;
    private TextView tvPlateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plates);

        ibPlateAddPhoto = (ImageButton) findViewById(R.id.ib_plate_add_photo);
        etPlateName = (EditText) findViewById(R.id.et_plate_name);
        etPlatePrice = (EditText) findViewById(R.id.et_plate_price);
        cbPlateMorning = (CheckBox) findViewById(R.id.cb_plate_morning);
        cbPlateAfternoon = (CheckBox) findViewById(R.id.cb_plate_afternoon);
        cbPlateNight = (CheckBox) findViewById(R.id.cb_plate_night);
        rbPlateEntrance = (RadioButton) findViewById(R.id.rb_plate_entrance);
        rbPlateMain = (RadioButton) findViewById(R.id.rb_plate_main);
        etPlateIngredients = (EditText) findViewById(R.id.et_plate_ingredients);
        tvPlateInfo = (TextView) findViewById(R.id.tv_plate_info);
    }

    public boolean validateInputs(){
        boolean valid = true;
        if(etPlateName.getText().toString().equals("")) {
            Toast.makeText(this, "Name is necessary", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(etPlatePrice.getText().toString().equals("")){
            Toast.makeText(this, "Price is necessary", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if((!cbPlateMorning.isChecked()) && (!cbPlateAfternoon.isChecked()) && (!cbPlateNight.isChecked())){
            Toast.makeText(this, "Timetable is necessary", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if((!rbPlateEntrance.isChecked()) && (!rbPlateMain.isChecked())){
            Toast.makeText(this, "Type is necessary", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(etPlateIngredients.getText().toString().equals("")){
            Toast.makeText(this, "Ingredients is necessary", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }

    public void showData(View view){
        if(validateInputs()){
            String info = "";
            info += etPlateName.getText().toString() + "\n";
            info += "$ " + etPlatePrice.getText().toString() + "\n";
            if(cbPlateMorning.isChecked()){
                info += "Morning \n";
            } else if (cbPlateAfternoon.isChecked()){
                info += "Afternoon \n";
            } else {
                info += "Night \n";
            }
            if(rbPlateEntrance.isChecked()){
                info += "Entrance \n";
            } else {
                info += "Main menu \n";
            }
            info += etPlateIngredients.getText().toString();
            tvPlateInfo.setText(info);
        } else {
            Toast.makeText(this, "Something was wrong!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
