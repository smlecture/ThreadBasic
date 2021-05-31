package kr.co.company.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
//    WorkerRunnable wr;
    boolean running = true;
    String strTag = "THREAD";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(strTag, "Now I am in onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        wr = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                for (i = 0; i < 20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Log.v("THREAD", "Runnable time=" + i);
                }
            }
        });
        running = true;
        wr.start();

        Log.v(strTag, "Now I am in onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(strTag, "Now I am in onStop");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.v(strTag, "Now I am in onPause");
    }

}