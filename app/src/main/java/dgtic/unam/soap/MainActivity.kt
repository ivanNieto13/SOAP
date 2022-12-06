package dgtic.unam.soap

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dgtic.unam.soap.databinding.ActivityMainBinding
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val executor = Executors.newSingleThreadExecutor()
    private val myHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener {
            val datoOne = binding.etParameterOne.text.toString().trim()
            val datoTwo = binding.etParameterTwo.text.toString().trim()
            getService(datoOne, datoTwo)
        }
    }

    private fun getService(datoOne: String, datoTwo: String) {
        executor.execute {
            val response = CallService().callAPI(Utils.METHOD_NAME, datoOne, datoTwo)
            myHandler.post {
                try {
                    binding.tvResult.text = response
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}