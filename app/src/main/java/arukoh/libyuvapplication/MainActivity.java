package arukoh.libyuvapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import arukoh.libyuv.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils utils = new Utils();
        TextView textView = findViewById(R.id.textView);
        textView.setText(utils.stringFromJNI());
    }
}
