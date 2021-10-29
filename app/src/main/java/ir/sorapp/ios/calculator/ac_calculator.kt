package ir.sorapp.ios.calculator

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class ac_calculator : AppCompatActivity()
{

    //Get Gloabl Variables Start
    lateinit var textinput:TextView
    var end_smaple=""
    var Sum=0f
    //Get Gloabl Variables End
    
    //Main Function Start
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac_calculator)

        //Get Componenets Start
        textinput=findViewById(R.id.input_textview)
        //Get Componenets End
    }
    //Main Function End

    //OnClick Buttons Event Function Start
    fun onclick_btns(v:View)
    {
        var Btn:Button=findViewById(v.id)

        //Get Buttons Events Start
        if(Btn.text.toString().equals("+"))
        {
            Add_F(textinput.text.toString().toFloat())
            end_smaple="+"
            textinput.text=0.toString()
        }
        else if(Btn.text.toString().equals("-"))
        {
            Sub_F(textinput.text.toString().toFloat())
            end_smaple="-"
            textinput.text=0.toString()
        }
        else if(Btn.text.toString().equals("*"))
        {
            Mul_F(textinput.text.toString().toFloat())
            end_smaple="*"
            textinput.text=0.toString()
        }
        else if(Btn.text.toString().equals("/"))
        {
            Div_F(textinput.text.toString().toFloat())
            end_smaple="/"
            textinput.text=0.toString()
        }
        else if(Btn.text.toString().equals("="))
        {
            if(end_smaple.toString().equals("+"))
            {
                Sum+=textinput.text.toString().toFloat()
            }
            else if(end_smaple.toString().equals("-"))
            {
                Sum-=textinput.text.toString().toFloat()
            }
            else if(end_smaple.toString().equals("*"))
            {
                Sum*=textinput.text.toString().toFloat()
            }
            else if(end_smaple.toString().equals("/"))
            {
                Sum/=textinput.text.toString().toFloat()
            }
            else if(end_smaple.toString().equals("%"))
            {
                Sum%=textinput.text.toString().toFloat()
            }
            end_smaple=""
            textinput.text=Sum.toString()
            Sum=0f
        }
        else if(Btn.text.toString().equals("%"))
        {
            Rediv_F(textinput.text.toString().toFloat())
            end_smaple="%"
            textinput.text=0.toString()
        }
        else if(Btn.text.toString().toLowerCase().equals("c"))
        {
            end_smaple=" "
            Sum=0f
            textinput.text="0"
        }
        else if(Btn.text.toString().equals("+/-"))
        {
            if(textinput.text.toString().indexOf(".") >= 0)
            {
                textinput.text = ("-" + textinput.text.toString()).toFloat().toString()
            }
            else
            {
                textinput.text = ("-" + textinput.text.toString()).toInt().toString()
            }
        }
        else if(Btn.text.toString().equals("."))
        {
            if(textinput.text.toString().indexOf(".")==-1)
            {
                if(textinput.text.toString().equals("0"))
                    textinput.text=("0."+Btn.text.toString())
                else
                    textinput.text=(textinput.text.toString()+Btn.text.toString())
            }
        }
        else
        {
            if(!textinput.text.toString().equals("0"))
                textinput.text=(textinput.text.toString()+Btn.text.toString())
            else
                textinput.text=(Btn.text.toString())
        }
        //Get Buttons Events End
    }
    //OnClick Buttons Event Function End

    //Add Event Start
    fun Add_F(b:Float)
    {
        if(Sum!=0f)
        {
            Sum += b
            textinput.text = Sum.toString()
        }
        else
        {
            Sum = b;
        }
    }
    //Add Event End

    //Sub Event Start
    fun Sub_F(b:Float)
    {
        if(Sum!=0f) {
            Sum -= b
            textinput.text = Sum.toString()
        }
        else
        {
            Sum=b
        }
    }
    //Sub Event End

    //Mul Event Start
    fun Mul_F(b:Float)
    {
        if(Sum!=0f) {
            Sum *= b
            textinput.text = Sum.toString()
        }
        else
        {
            Sum=b;
        }
    }
    //Mul Event End

    //Divided Event Start
    fun Div_F(b:Float)
    {
        if(Sum!=0f) {
            Sum /= b
            textinput.text = Sum.toString()
        }
        else
        {
            Sum=b
        }
    }
    //Divided Event End

    //ReDivided Event Start
    fun Rediv_F(b:Float)
    {
        if(Sum!=0f) {
            Sum %= b
            textinput.text = Sum.toString()
        }
        else
        {
            Sum=b
        }
    }
    //ReDivided Event End

}