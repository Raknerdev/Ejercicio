package com.pedroalvarez.ejercicio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.pedroalvarez.ejercicio.R
import kotlinx.android.synthetic.main.fragment_nav.*

class NavFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchUrl = "https://google.com"

        webView.webChromeClient = object : WebChromeClient(){

        }
        webView.webViewClient = object : WebViewClient(){

        }
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled =true
        webView.loadUrl(searchUrl)
    }
}