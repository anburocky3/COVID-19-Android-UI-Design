package cdn.covid19

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val countryNames = arrayOf(
        "IND", "USA", "MY", "AFG", "MF"
    )

    val countryFlag = intArrayOf(
        R.drawable.india,
        R.drawable.uk,
        R.drawable.malesiya,
        R.drawable.afganistan,
        R.drawable.maxico
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countryNames)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flag.setImageResource(countryFlag[position])
            }

        }


        statistics.setOnClickListener {
            startActivity(Intent(this@MainActivity, StatisticsActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        }
    }

}
