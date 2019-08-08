package webservices.rp.edu.demogetmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetAge.setOnClickListener {
            val userDOB = etDOB.text.toString()
            if (userDOB.isNotEmpty()){
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()
                tvShowAge.text = "Your age is $age"

                var grp = ""
                /*
                if (age < 18) {
                    grp = "Underage"
                } else if (age in 18..65) {
                    grp = "Young people"
                } else if (age in 66..79) {
                    grp = "Middle-aged"
                } else if (age in 80..99) {
                    grp = "Elderly"
                } else {
                    grp = "Long-lived elderly"
                }
                */
                when (age) {
                    in 0..17 -> grp = "Underage"
                    in 18..65 -> grp = "Young people"
                    in 66..79 -> grp = "Middle-aged"
                    in 80..99 -> grp = "Elderly"
                    else -> {
                        grp = "Long-lived elderly"
                    }
                }
                tvAgeGroup.text = "$grp"
            } else {
                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
