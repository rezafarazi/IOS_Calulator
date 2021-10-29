package ir.sorapp.ios.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        //Initializing Activity Start
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initializing Activity End

        //Count Down Timer Start
        val timer = object : CountDownTimer(100, 2500)
        {
            override fun onTick(p0: Long)
            {

            }

            override fun onFinish()
            {
                startActivity(Intent(applicationContext, ac_calculator::class.java))
                cancel()
            }
        }
        timer.start()
        //Count Down Timer End
    }
}