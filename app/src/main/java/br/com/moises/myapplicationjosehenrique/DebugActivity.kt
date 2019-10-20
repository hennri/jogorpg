package br.com.moises.myapplicationjosehenrique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {


    private val TAG = "LMSApp"
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, className + ".onMetodoCicloVida() chamado")
    }

}
