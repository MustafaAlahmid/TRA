package com.sucho.placepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.sign


class acount : AppCompatActivity() {

    lateinit var username:TextView
    lateinit var password:TextView
    lateinit var button: Button
    val myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acount)
        username = findViewById(R.id.userName)
        password = findViewById(R.id.password)


        button = findViewById(R.id.submitbtn)
        button.setOnClickListener {
            val u1 = username.text.toString().trim()
            val p1 = password.text.toString().trim()
            if (u1 == ""){
                Toast.makeText(this,"Please put an email",Toast.LENGTH_LONG).show()
            }else if (p1 ==""){
                Toast.makeText(this,"Please put a passport",Toast.LENGTH_LONG).show()
            }
            else{
                if(isEmailValid(u1)){
                    SignUp(u1,p1)
                }else{
                    Toast.makeText(this,"Please enter a valid email",Toast.LENGTH_LONG).show()

                }
            }



        }
    }
    fun SignUp(email:String, password:String){

        myAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,
            OnCompleteListener { task ->
                if (task.isComplete) {
                Toast.makeText(this,"done",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show()
                }
            }
        )
    }
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}

