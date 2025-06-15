package codeSolution.com.s23010597.chethaka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void lab1Click(View view) {
        Toast.makeText(this, "Lab 1 Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Lab_1.class));
    }

    public void lab2_click(View view) {
        Toast.makeText(this, "Lab 2 Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Lab_2.class));
    }
    public void lab3_click(View view) {
        Toast.makeText(this, "Lab 3 Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Lab_3.class));
    }

    public void lab4_click(View view) {
        Toast.makeText(this, "Lab 4 Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Lab_4.class));
    }

}