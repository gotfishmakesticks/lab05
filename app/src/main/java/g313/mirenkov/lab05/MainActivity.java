package g313.mirenkov.lab05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean broadcasting = false;
    EditText edit;
    CheckBox truebox;
    CheckBox falsebox;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.act1_edit);
        truebox = findViewById(R.id.truebox);
        falsebox = findViewById(R.id.falsebox);
    }


    public void on_exit_click(View v)
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Exit application");
        ad.setMessage("Are you sure you want to exit the application?");
        ad.setPositiveButton(android.R.string.yes, (dialog, which) -> finish());
        ad.setNegativeButton(android.R.string.no, null);
        ad.setIcon(android.R.drawable.ic_dialog_alert);
        ad.show();
    }

    public void on_dialog_open(View v)
    {
        String str = edit.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("edit", str);
        intent.putExtra("bool", truebox.isChecked());
        startActivityForResult(intent, 78);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 78 && data != null) {
            String str = data.getStringExtra("edit");
            Toast.makeText(getApplication(), str, Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
            edit.setText(data.getStringExtra("edit"));
            truebox.setChecked(data.getBooleanExtra("bool", false));
            falsebox.setChecked(!data.getBooleanExtra("bool", false));
        }
    }

    public void on_checkbox_change(View v)
    {
        if (broadcasting) {
            broadcasting = false;
            return;
        }
        broadcasting = true;
        if (v == truebox) {
            falsebox.setChecked(!truebox.isChecked());
        }
        else if (v == falsebox) {
            truebox.setChecked(!falsebox.isChecked());
        }
        broadcasting = false;
    }
}