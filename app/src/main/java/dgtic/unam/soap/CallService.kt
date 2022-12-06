package dgtic.unam.soap

import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class CallService {
    fun callAPI(methodName: String, parameterOne: String, parameterTwo: String): String {
        var result = ""
        val SOAP_ACTION = "${Utils.NAMESPACE}$methodName"
        val soapObject = SoapObject(Utils.NAMESPACE, methodName)
        soapObject.addProperty("intA", parameterOne)
        soapObject.addProperty("intB", parameterTwo)
        val envelope = SoapSerializationEnvelope(SoapSerializationEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = true
        val httpTransportSE = HttpTransportSE(Utils.URL)
        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val response = envelope.response
            result = response.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }
}