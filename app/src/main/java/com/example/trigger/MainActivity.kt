package com.example.trigger

import android.app.ActivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ActivityNotFoundException
import android.content.pm.PackageManager
import android.widget.Toast
import android.content.ComponentName
import android.content.Context
import android.os.Binder
import android.support.v4.content.ContextCompat.startActivity








class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       triggerBtn.setOnClickListener {
           Log.d("Cliched >>>", "Here")

           val intent = Intent()
//           val intent = Intent(Intent.ACTION_MAIN)

           intent.component = ComponentName("com.iisysgroup.ajocard", "com.iisysgroup.ajocard.gtb.activites.bills.transfers.NameEnquiryActivity")
//           intent.addCategory(Intent.CATEGORY_LAUNCHER)

           if (packageManager.resolveActivity(intent, 0) != null) {
               startActivity(intent)
           } else {
               Toast.makeText(this, "No app installed that can perform this action", Toast.LENGTH_SHORT).show()
           }


       }

    }





    fun test(time:String) {
        //Get caller information
        //UID

        Log.d("Moment >>>", time)

        var uid: Int = Binder.getCallingUid();

        var pm: PackageManager = getPackageManager();
        var name: String = pm.getNameForUid(uid);
        //name will be sharedUserId of caller, OR if not set the package name of the caller

        var packageNames: Array<String> = pm.getPackagesForUid(uid);
        //packageNames is a array of packages using that UID, could be more than 1 if using sharedUserIds

        Log.d("ITestService", String.format("Calling uid: %d (getNameForUid: %s)", uid, name));
        for (vali in packageNames) {
            Log.d("ITestService", String.format("getPackagesForUid: %s", vali));
        }


        //PID
        val pid = Binder.getCallingPid()
        Log.d("ITestService", String.format("Calling pid: %d", pid))
        var processName = ""

        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processes = am.runningAppProcesses
        for (proc in processes) {
            if (proc.pid == pid) {
                processName = proc.processName
                Log.d("ITestService", String.format("Found ProcessName of pid(%d): %s", pid, processName))

                //processName will be the package name of the caller, YEAH!
            }
        }
    }


    fun test(time:String,uid:Int) {
        //Get caller information
        //UID

        Log.d("Moment >>>", time)

//        var uid: Int = Binder.getCallingUid();

        var pm: PackageManager = getPackageManager();
        var name: String = pm.getNameForUid(uid);
        //name will be sharedUserId of caller, OR if not set the package name of the caller

        var packageNames: Array<String> = pm.getPackagesForUid(uid);
        //packageNames is a array of packages using that UID, could be more than 1 if using sharedUserIds

        Log.d("ITestService >>>>>>", String.format("Calling uid: %d (getNameForUid: %s)", uid, name));
        for (vali in packageNames) {
            Log.d("ITestService  >>>>>>", String.format("getPackagesForUid: %s", vali));
        }

        //PID
        val pid = Binder.getCallingPid()
        Log.d("ITestService >>>>>>", String.format("Calling pid: %d", pid))
        var processName = ""

        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processes = am.runningAppProcesses
        for (proc in processes) {
            if (proc.pid == pid) {
                processName = proc.processName
                Log.d("ITestService >>>>>>", String.format("Found ProcessName of pid(%d): %s", pid, processName))

                //processName will be the package name of the caller, YEAH!
            }
        }
    }
}
