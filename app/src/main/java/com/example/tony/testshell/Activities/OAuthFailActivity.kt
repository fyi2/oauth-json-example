package com.example.tony.testshell.Activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tony.testshell.R

class OAuthFailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth_fail)
    }


    fun returnHome(view: View){
        var intent = Intent(this, MainActivity::class.java)
        var returnIntent = this.intent

        returnIntent.putExtra("return", "return from OAuth Fail")
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
        // startActivity(intent) Used for simple intent calls
    }
}
