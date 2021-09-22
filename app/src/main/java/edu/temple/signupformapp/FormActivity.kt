package edu.temple.signupformapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import edu.temple.signupformapp.R

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EditText variables
        val _name : EditText = findViewById(R.id.name_input)
        val _email : EditText = findViewById(R.id.email_input)
        val _pass : EditText = findViewById(R.id.pass_input)
        val _repass : EditText = findViewById(R.id.repass_input)

        // text-converted variables from above
        val name = _name.text
        val email = _email.text
        val pass = _pass.text
        val repass = _repass.text

        // button + onclick listener to check missing fields and password confirmation
        val button : Button = findViewById(R.id.save_button)
        button.setOnClickListener {
            if (name.isEmpty()) {_name.error = "Name required"}
            if (email.isEmpty()) {_email.error = "Email required"}
            if (pass.isEmpty()) {_pass.error = "Password required"}
            if (repass.isEmpty()) {_repass.error = "Password confirmation required"}
            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && repass.isNotEmpty()) {
                if (pass.toString() == repass.toString()) {
                    // passwords match, therefore everything is good to go
                    Toast.makeText(this@FormActivity, "Welcome, ${name}, to our Sign Up Form App!", Toast.LENGTH_LONG).show()
                } else {
                    // password do not match, try again with the passwords
                    _repass.error = "Passwords do not match. Try again."
                }
            }
        }
    }
}