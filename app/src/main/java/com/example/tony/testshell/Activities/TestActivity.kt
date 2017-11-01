package com.example.tony.testshell.Activities

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tony.testshell.Adapters.TabbedMenuAdapter
import com.example.tony.testshell.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //        setSupportActionBar(toolbar)
        var sectionAdapter: TabbedMenuAdapter

        sectionAdapter = TabbedMenuAdapter(supportFragmentManager)
        viewPagerID.adapter = sectionAdapter
        tabs.setupWithViewPager(viewPagerID)
        tabs.setTabTextColors(Color.WHITE, Color.GREEN)
    }


    fun returnHome(view: View){
        var intent = Intent(this, MainActivity::class.java)
        var returnIntent = this.intent

        returnIntent.putExtra("return", "return from Test")
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
        // startActivity(intent) Used for simple intent calls
    }

    fun popUp(view: View){
        val popView = layoutInflater.inflate(R.layout.pop_up,null)
        var builder: AlertDialog.Builder= AlertDialog.Builder(this)
        builder.setView(popView)
        builder.setTitle("Wally")
        builder.setNeutralButton("Cancel", DialogInterface.OnClickListener(){
            dialogInterface, i -> Toast.makeText(this,"Bye", Toast.LENGTH_LONG).show()
        })
        builder.setPositiveButton("OK", DialogInterface.OnClickListener(){
            dialogInterface, i -> Toast.makeText(this,"Great Choice", Toast.LENGTH_LONG).show()
        })
        builder.show()
    }
}
