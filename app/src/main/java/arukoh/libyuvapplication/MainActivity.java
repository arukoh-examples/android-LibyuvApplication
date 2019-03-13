package arukoh.libyuvapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.ByteBuffer;

import arukoh.nativelib.Libyuv;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConvert(android.view.View view) {
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.face);
        image = image.copy(Bitmap.Config.ARGB_8888, false);
        final int h = image.getHeight();
        final int w = image.getWidth();

        ByteBuffer byteBuffer = ByteBuffer.allocate(image.getByteCount());
        image.copyPixelsToBuffer(byteBuffer);
        byte[] rgb = byteBuffer.array();
        final byte[] yuv = new byte[w * h * 3 / 2];

        Libyuv.ARGBToNV21(rgb, w, h, yuv);
        Libyuv.NV21ToARGB(yuv, w, h ,rgb);

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(rgb));

        ImageView iv = findViewById(R.id.imageView);
        iv.setImageBitmap(bitmap);
    }
}
