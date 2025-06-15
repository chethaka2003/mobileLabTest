package codeSolution.com.s23010597.chethaka;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lab_2 extends AppCompatActivity {

    dbHelper myDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_2);
        myDb = new dbHelper(this);
    }

    public void loginBtn(View view) {

        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);

        if (userName.getText().toString() != "admin" && password.getText().toString() != "admin"){
            Toast.makeText(this,"Inalid user name and password",Toast.LENGTH_SHORT).show();
       }
       else {
          Toast.makeText(this,"You have logged in successfully",Toast.LENGTH_SHORT).show();
       }
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

                    // TODO: Compare with original password here
                    // Example: if (confirmedPassword.equals(originalPassword)) { ... }

                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
