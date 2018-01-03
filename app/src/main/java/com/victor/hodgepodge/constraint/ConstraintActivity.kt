package com.victor.hodgepodge.constraint

import android.app.Activity
import android.os.Bundle
import android.widget.*
import com.victor.hodgepodge.R

/**
 * Created by victor on 17-9-18.
 */
class ConstraintActivity : Activity() {

    private var selectCb: CheckBox? = null
    private var imageIv: ImageView? = null
    private var nameTv: TextView? = null
    private var propertyTv: TextView? = null
    private var labelLayout: LinearLayout? = null
    private var priceTv: TextView? = null
    private var minusIv: ImageView? = null
    private var countEt: EditText? = null
    private var addIV: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_main_layout)

        initComponent()
        initValue()


    }

    private fun initComponent() {
        selectCb = findViewById(R.id.cart_checkBox) as CheckBox
        imageIv = findViewById(R.id.cart_sku_icon) as ImageView
        nameTv = findViewById(R.id.cart_name) as TextView
        propertyTv = findViewById(R.id.cart_property) as TextView
        labelLayout = findViewById(R.id.cart_label) as LinearLayout
        priceTv = findViewById(R.id.cart_price) as TextView
        minusIv = findViewById(R.id.cart_minus) as ImageView
        countEt = findViewById(R.id.cart_editText) as EditText
        addIV = findViewById(R.id.cart_add) as ImageView
    }

    private fun initValue() {
        nameTv?.text = "获取节点类的方法，过滤掉那些不是getter的方法，然后只考虑返回节点或节点集合。调用这些方法，并在子节点上递归地调用walk方法"
        propertyTv?.text = "height : 0.20kg,color:red"
        priceTv?.text = "￥30.5"
        countEt?.setText("2")

        val subLabel = ImageView(this)
        subLabel.setImageResource(android.R.drawable.btn_star)
        labelLayout?.addView(subLabel, LinearLayout.LayoutParams(45, 45))

    }
}