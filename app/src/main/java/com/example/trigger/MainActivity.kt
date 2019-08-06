package com.example.trigger

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
import android.support.v4.content.ContextCompat.startActivity








class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       triggerBtn.setOnClickListener {
           Log.d("Cliched >>>", "Here")
//           var intent = Intent()
//           intent.action = "com.iisysgroup.ajocard.payments_menu.PaymentsActivity"
//           this.startActivity(intent)

//           openApp(this@MainActivity,"com.iisysgroup.ajocard.payments_menu.PaymentsActivity")




//           val pm = this.packageManager
//
//           try {
//               val it = pm.getLaunchIntentForPackage("com.mycompany.DO_SOMETHING")
//
//               if (null != it)
////                   it.action ="com.mycompany.DO_SOMETHING"
//                   this.startActivity(it)
//           } catch (e: ActivityNotFoundException) {
//
//           }
//

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


//    fun openApp(context: Context, packageName: String): Boolean {
//        val manager = context.getPackageManager()
//        try {
//
//            val i = manager.getLaunchIntentForPackage(packageName)
//                    ?: return false
//            //throw new ActivityNotFoundException();
//            i.addCategory(Intent.CATEGORY_LAUNCHER)
//            context.startActivity(i)
//            return true
//        } catch (e: ActivityNotFoundException) {
//            Log.e("Error", e.toString())
//                           Toast.makeText(context, "No app installed that can perform this action", Toast.LENGTH_SHORT).show()
//
//            return false
//        }
//
//    }
}
