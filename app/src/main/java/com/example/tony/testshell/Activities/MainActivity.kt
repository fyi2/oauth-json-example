package com.example.tony.testshell.Activities

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ca.mimic.oauth2library.OAuth2Client
import ca.mimic.oauth2library.OAuthResponse
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.example.tony.testshell.Data.*
import com.example.tony.testshell.R
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var response: OAuthResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun authenticate(view: View){

        ThreadTask().execute()
    }

    fun getPractice(view: View){
        val apiUrl = URL_BASE+ CONST_PRACTICE_ID.toString()+ URL_PRACTICE_INFO
        val authorize = "Authorization"
        val bearer = "Bearer "+Globals.authKey.toString()
        var security = hashMapOf(authorize to bearer)
        FuelManager.instance.baseHeaders = security
        apiUrl.httpGet().responseString { request, response, result ->
            val (data , error) = result
            if (error == null){
                Log.d(DEBUG, "STRING SUCCESS")
                Log.d(DEBUG,result.toString())
                practiceViewID.text = getPracticeName(result.toString())
            }
            else {
                practiceViewID.text =  "NETWORK RESPONSE FAILED"
            }
        }
    }

        fun getPracticeName(resultString:String):String {
            // Strip extra padding
            val FrontChars = 10
            val backChars = 1

            var newString = resultString.drop(FrontChars).dropLast(backChars)

            val parser: Parser = Parser()
            val sb: StringBuilder = StringBuilder(newString)
            var jsonObj: JsonObject = parser.parse(sb) as JsonObject
            var jsonArr = jsonObj["practiceinfo"] as JsonArray<*>

            jsonObj = jsonArr[0] as JsonObject

            val practiceName = jsonObj["name"] as String

            //Log.d(DEBUG,"Working String = $practiceName")

            return practiceName
        }

    fun newInventory(view: View) {
        var intent = Intent(applicationContext, AddInventoryActivity::class.java)
        startActivity(intent)
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
    fun newPatient(view: View){
        val intent = Intent(applicationContext,NewUserActivity::class.java)
        startActivity(intent)
    }

    private inner class ThreadTask: AsyncTask<String,String, String>(){
        override fun doInBackground(vararg p0: String?): String {
            var result:String = ""
            val key = OAUTH_KEY
            val secret = OAUTH_SECRET
            val testURL = OAUTH_URL
            val grantType = OAUTH_GRANT
            try {
                var client: OAuth2Client = OAuth2Client.Builder(key,secret, key,secret,testURL)
                        .grantType(grantType)
                        .username(key)
                        .password(secret)
                        .build()

                response = client.requestAccessToken()

                Globals.authKey = response!!.accessToken
                val btnColor = resources.getColor(R.color.btnGreen)
                loginButton.setBackgroundColor(btnColor) //= "@color/btnGreen"
                result = "success"

            } catch (e:Exception){
                e.printStackTrace()
            }
            return result
        }

        override fun onPostExecute(result: String?) {
            if(response!!.isSuccessful){
                Log.d(DEBUG,Globals.authKey)
            } else {
                var intent = Intent(applicationContext, OAuthFailActivity::class.java)
                startActivity(intent)
            }
        }
    }

 }



