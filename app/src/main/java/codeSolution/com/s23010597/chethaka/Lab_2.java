package codeSolution.com.s23010597.chethaka;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lab_2 extends AppCompatActivity {

    dbHelper myDb;
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_2);
        myDb = new dbHelper(this);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

    }

    //Validating the password
    public void loginBtn(View view) {
        myDb.validateData(password.getText().toString());

  }

    public void createBtn(View view) {
        // Create an EditText for password confirmation input
        final EditText confirmPasswordInput = new EditText(this);
        confirmPasswordInput.setHint("Confirm Password");

        // Build the AlertDialog
        new AlertDialog.Builder(this)
                .setTitle("Confirm Password")
                .setMessage("Please enter your password again to confirm:")
                .setView(confirmPasswordInput)
                .setPositiveButton("Confirm", (dialog, which) -> {
                    String confirmedPassword = confirmPasswordInput.getText().toString();

                    // Validation
                    if (confirmedPassword == password.getText().toString()){
                        myDb.insertData(userName.getText().toString(),password.getText().toString());
                        dialog.dismiss();
                    }
                    else {
                        new AlertDialog.Builder(this)
                                .setTitle("Error")
                                .setMessage("Passwords do not match. Please try again.")
                                .setPositiveButton("OK", (d, w) -> d.dismiss())
                                .show();
                    }

                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }


}
