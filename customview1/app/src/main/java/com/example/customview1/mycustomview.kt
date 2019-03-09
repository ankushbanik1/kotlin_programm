package com.example.customview1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import java.util.jar.Attributes

class mycustomview(context:Context,attr:AttributeSet):LinearLayout(context,attr) {
    private var autoCompleteTextView: AutoCompleteTextView
    private var list: ListView
    private var textv1: TextView
    private var img: ImageView

    init {

        var infaletr = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = infaletr.inflate(R.layout.customlayout, this, true)


        var selecteditems: MutableList<String> = ArrayList()
        var allitems: MutableList<String> = ArrayList()

        autoCompleteTextView = findViewById(R.id.auto1) as AutoCompleteTextView
        list = findViewById(R.id.listv1) as ListView
        textv1 = findViewById(R.id.textv2) as TextView
        img = findViewById(R.id.add) as ImageView

        autoCompleteTextView.threshold = 0

        img.setOnClickListener {
            val selectedstring = autoCompleteTextView.text.trim().toString()

            when {
                selectedstring.isEmpty() -> Toast.makeText(getContext(), "enter some data", Toast.LENGTH_SHORT).show()
                selecteditems.contains(selectedstring) -> Toast.makeText(
                    getContext(),
                    "data already exsist",
                    Toast.LENGTH_SHORT
                ).show()
                else -> {
                    selecteditems.add(0, selectedstring)
                }


            }
        }
    }

    inner class mycustomviewAdapter(context: Context, var resource: Int, objects: MutableList<String>) :
        ArrayAdapter<String>(context, resource, objects)

    private val inflater: LayoutInflater = LayoutInflater.from(context)


}






    }
