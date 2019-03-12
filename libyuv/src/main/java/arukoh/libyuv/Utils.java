package arukoh.libyuv;

public class Utils {

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
