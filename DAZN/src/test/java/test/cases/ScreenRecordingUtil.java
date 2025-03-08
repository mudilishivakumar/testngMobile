package test.cases;

import java.io.IOException;

public class ScreenRecordingUtil {
    public static void startRecording(String fileName) throws IOException, InterruptedException {
        String command = "adb shell screenrecord /sdcard/" + fileName;
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }

    public static void stopRecording() throws IOException, InterruptedException {
        String command = "adb shell pkill -l 3 -f screenrecord";
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}


