package com.example.tony.testshell.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.example.tony.testshell.Data.*
import com.example.tony.testshell.R
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new_user.*

class NewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

    }
    fun buildPatient(view: View){
        var fname = npFistNameID.text.toString().replace(" ","+")
        var lname = npLastNameID.text.toString().replace(" ","+")
        var mobilephone = npPhoneID.text.toString().replace(" ","+")
                .replace("(","%28").replace(")","%29")
        var email = npEmailID.text.toString().replace("@","%40")
        var address = npAddress1ID.text.toString().replace(" ","+")
        var city = npCityID.text.toString().replace(" ","+")
        var dob = npDobID.text.toString().replace("/","%2F")

        val bodyString = "firstname="+fname+"&lastname="+lname+"&departmentid=1&address1="+
                address+"&email="+email+"&city="+city+"&dob="+dob+"&mobilephone="+mobilephone+
                "&zip=01752"

        putPractice(bodyString)

    }

    fun putPractice(bodyString: String){
        val apiUrl = URL_BASE + CONST_PRACTICE_ID.toString()+ URL_PATIENTS
        val authorize = "Authorization"
        val bearer = "Bearer "+ Globals.authKey.toString()
        var security = hashMapOf(authorize to bearer)
        FuelManager.instance.baseHeaders = security

        Log.d(DEBUG,"URL = $apiUrl")
        Log.d(DEBUG,apiUrl.httpPut().body(bodyString).cUrlString())

        apiUrl.httpPost().body(bodyString).responseString { request, response, result ->
            val (data , error) = result
            if(error == null){
                Log.d(DEBUG, "Success - "+data.toString())
                Globals.patientID = getPatientID(data.toString())
                Log.d(DEBUG,"Patient ID = ${Globals.patientID}")
            } else {
                Log.d(DEBUG,error.message)
            }
        }
    }

    fun getPatientID(json: String):Int {

        val parser = Parser()
        val sb: StringBuilder = StringBuilder(json)
        val jsonArr = parser.parse(sb) as JsonArray<*>
        val jsonObj = jsonArr[0] as JsonObject

        val id = jsonObj["patientid"] as String
        return id.toInt()
    }
}
