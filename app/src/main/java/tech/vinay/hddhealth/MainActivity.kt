package tech.vinay.hddhealth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hours_edit_text = findViewById<TextInputEditText>(R.id.hours_edit_text)
        val check_button = findViewById<ExtendedFloatingActionButton>(R.id.check_button)
        val health_message_text_view = findViewById<MaterialTextView>(R.id.health_message_text_view)
        val status_message_text_view = findViewById<MaterialTextView>(R.id.status_message_text_view)
        val replace_text_view = findViewById<MaterialTextView>(R.id.replace_text_view)

        check_button.setOnClickListener {
            val text = hours_edit_text.text.toString()
            val hours = Integer.parseInt(text)

            val months=hours/(24*30.0)
            val years=(months/12.00)

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val monthsRoundOff = df.format(months).toFloat()
            val yearsRoundOff = df.format(years).toFloat()

            val yearsToReplace=5-yearsRoundOff


            health_message_text_view.text = "Heyy, your HDD has been been active for about ${monthsRoundOff} months!!"

            if(yearsRoundOff>=0 && yearsRoundOff<=1.5){
                status_message_text_view.text="Status: 🟢 (Healthy AF)"
            }
            else if(yearsRoundOff>=1.5 && yearsRoundOff<=3.5){
                status_message_text_view.text="Status: 🟠 (Good)"
            }
            else if(yearsRoundOff>3.5){
                status_message_text_view.text="Status: 🔴 (Severe)"
            }

            replace_text_view.text = "You should prefer to replace your HDD after $yearsToReplace of active time."


            return@setOnClickListener
    }
    }
}



