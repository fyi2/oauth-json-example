package com.example.tony.testshell.Activities

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tony.testshell.Adapters.TabbedMenuAdapter
import com.example.tony.testshell.Data.CODE_STATION
import com.example.tony.testshell.Data.CODE_TABBED
import com.example.tony.testshell.R
import kotlinx.android.synthetic.main.activity_test.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // requestCode = Integer we decide on
        //resultCode = Android Code
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_STATION) {
            if (resultCode == Activity.RESULT_OK) {
                var result = data!!.extras.get("return").toString()
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show()
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
        if (requestCode == CODE_TABBED) {
            if (resultCode == Activity.RESULT_OK) {
                var result = data!!.extras.get("return").toString()
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun testJump(view: View){
        val intent = Intent(applicationContext,TestActivity::class.java)
        startActivity(intent)
    }
}
