package g313.mirenkov.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {

    EditText edit;
    Switch switchy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("edit");
        boolean bool = intent.getBooleanExtra("bool", false);
        edit = findViewById(R.id.act2_edit);
        switchy = findViewById(R.id.switchy);
        switchy.setChecked(bool);
        edit.setText(str);

    }

    public void on_exit_click(View v)
    {
        finish();
    }

    public void on_ok_click(View v)
    {
        String str = edit.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("edit", str);
        intent.putExtra("bool", switchy.isChecked());
        setResult(RESULT_OK, intent);
        finish();
    }
}