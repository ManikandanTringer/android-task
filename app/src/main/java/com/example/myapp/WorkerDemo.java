import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;

public class WorkerDemo extends Worker {

    private static final String TAG = "WorkerDemo";

    @NonNull
    @Override
    public Result doWork() {
        Data inputData=getInputData();
        int number=inputData.getInt("number",-1);
        Log.d(TAG, "doWork: "+number);

        for(int i=number;i>0;i--) {
            Log.d(TAG, "doWork: i="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            return null;
    }
}
