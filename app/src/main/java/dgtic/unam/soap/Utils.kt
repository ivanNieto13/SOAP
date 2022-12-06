package dgtic.unam.soap

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

class Utils {
    companion object {
        const val URL = "http://www.dneonline.com/calculator.asmx?"
        const val NAMESPACE = "http://tempuri.org/"
        const val METHOD_NAME = "Multiply"

        @RequiresApi(Build.VERSION_CODES.N)
        fun isConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            return capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)

        }
    }
}