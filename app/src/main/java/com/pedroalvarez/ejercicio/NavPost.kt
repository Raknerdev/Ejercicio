package com.pedroalvarez.ejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_nav_post.*

class NavPost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_post)
        showToolbar(null, true)
        if(intent.extras != null){

            val dataUrl= intent.getStringExtra("Url")
            webView.webChromeClient = object : WebChromeClient(){
            }
            webView.webViewClient = object : WebViewClient(){
            }
            val settings: WebSettings = webView.settings
            settings.javaScriptEnabled =true
            if (dataUrl != null) {
                webView.loadUrl(dataUrl)
            }else{
                Toast.makeText(this,"Error en la dirección",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Error inesperado",Toast.LENGTH_LONG).show()
        }
    }

    private fun showToolbar(tittle: String?, upButton: Boolean) {
        val toolbar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(tittle)
        supportActionBar!!.setDisplayHomeAsUpEnabled(upButton)
    }
}