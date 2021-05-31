package kr.co.company.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Thread wr;

    Button button;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wr = new Thread(new Runnable() {
                    public void run() {

                        imageView.setImageResource(R.drawable.lena);
                    }
                });
                wr.start();
            }
        });
    }

/*    @Override
    public void onStart() {
        super.onStart();
        wr = new Thread(new Runnable() {
            public void run() {

                imageView.setImageResource(R.drawable.lena);
            }
        });
        wr.start();
    }*/
}