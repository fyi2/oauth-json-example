package com.example.tony.testshell.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.beust.klaxon.JsonArray
import com.beust.klaxon.Parser
import com.example.tony.testshell.Data.*
import com.example.tony.testshell.R
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import kotlinx.android.synthetic.main.activity_add_inventory.*

class AddInventoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_inventory)
    }

    fun addItem(view: View) {
        val jsonString = buildJson(view)
        val apiUrl = URL_BASE + CONST_PRACTICE_ID.toString()+ URL_POST_INVENTORY
        val authorize = "Authorization"
        val bearer = "Bearer "+ Globals.authKey.toString()
        var security = hashMapOf(authorize to bearer)
        FuelManager.instance.baseHeaders = security


        Log.d(DEBUG,"URL = $apiUrl")
        Log.d(DEBUG,apiUrl.httpPost().body(jsonString).cUrlString())

        apiUrl.httpPost().body(jsonString).responseString { request, response, result ->
            val (data , error) = result
            if(error == null){
                Log.d(DEBUG, "Success - "+data.toString())
                Globals.inventoryID = getInventoryID(data.toString())
                Log.d(DEBUG,"Inventory ID = ${Globals.inventoryID}")
            } else {
                Log.d(DEBUG,"Here is the current stumbling block:")
                Log.d(DEBUG,error.message)
            }
        }
    }

    fun getInventoryID(inventoryString:String):Int {
        val parser = Parser()
        val sb: StringBuilder = StringBuilder(inventoryString)
        val jsonArr = parser.parse(sb) as JsonArray<*>
        return jsonArr[0].toString().toInt()
    }
    fun buildJson(view: View): String {

        val manuID = aiManufacturingID.text.toString()
        val manuName = aiManufactureNameID.text.toString()
        val name = aiNameID.text.toString()

        val jsonStr = StringBuilder("inventoryitems=[{\"manufacturerid\":\"$manuID\",\"manufacturername\":\"$manuName\",\"name\":\"$name\",\"categoryid\":\"123\"}]")
        Log.d(DEBUG,jsonStr.toString())


        return jsonStr.toString()
    }
}
