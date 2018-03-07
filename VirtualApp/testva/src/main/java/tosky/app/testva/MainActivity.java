package tosky.app.testva;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lody.virtual.client.core.InstallStrategy;
import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.client.ipc.VActivityManager;
import com.lody.virtual.remote.InstallResult;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int flags = InstallStrategy.UPDATE_IF_EXIST;
        //InstallResult xx = VirtualCore.get().installPackage("/data/app/tosky.app.testplugin-1/base.apk", flags);

        File sd = Environment.getExternalStorageDirectory();
        Log.e("VA", "sd = " + sd.getPath() + "/test.apk");
        Log.e("VA", "canRead = " + new File(sd.getPath() + "/test.apk").canRead());
        InstallResult xx = VirtualCore.get().installPackage(sd.getPath() + "/test.apk", flags);

        Log.e("VA", "xx.error = " + xx.error);
        Log.e("VA", "xx.packageName = " + xx.packageName);

        Intent intent = VirtualCore.get().getLaunchIntent("tosky.app.testplugin", 0);
        VActivityManager.get().startActivity(intent, 0);
    }

}
