package arukoh.nativelib;

public class Libyuv {

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("yuv");
    }

    public native static void ARGBToNV21(byte[] rgb, int width, int height, byte[] yuv);
    public native static void NV21ToARGB(byte[] yuv, int width, int height, byte[] rgb);
}
