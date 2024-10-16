package dam.moviles.t1_proyecto02

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.t1_proyecto02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Este objeto contiene todos los controles del archivo activity_main.xml
    private lateinit var controles:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Esta línea crea el objeto controler con los objetos que hay en el archivo activity_main.xml
        controles = ActivityMainBinding.inflate(layoutInflater)

        ///la interfaz de MainActivity es el FrameLayout que es el padre de activity_main.xml
        setContentView(controles.root)

        this.inicializarBotones()
    }

    fun inicializarBotones() {
        controles.btnSeleccionarCurso.setOnClickListener{
            val curso:String = controles.spiCurso.selectedItem.toString()
            controles.txtAsignatura.text = getListaAsignaturasBonica(this.getAsignaturas(curso))
        }

        controles.btnEnviar.setOnClickListener() {
            val texto:String = controles.txtObservaciones.text.toString()
            Toast.makeText(
                this, //Se verá en la activity que estamos programando
                getString(R.string.mensajeToast,texto), //texto que se verá
                Toast.LENGTH_LONG //duración
            ).show()
        }
    }

    fun getAsignaturas(curso:String):List<String>{
        return when(curso){
            "1º DAM" -> listOf(getString(R.string.programacion),"entornos","marcas","base de datos","sistemas")
            "2º DAM" -> listOf("móviles","interfaces","acceso a datos","servicios y procesos","sistemas de gestión empresarial")
            else -> throw Exception("curso no admitido")
        }
    }
    /*fun getAsignaturas(curso:String):List<String> =
        when(curso){
            "1º DAM" -> listOf(getString(R.string.programacion),"entornos","marcas","base de datos","sistemas")
            "2º DAM" -> listOf("móviles","interfaces","acceso a datos","servicios y procesos","sistemas de gestión empresarial")
            else -> throw Exception("curso no admitido")
        }*/

    fun getListaAsignaturasBonica(lista:List<String>):String =
        lista
            .map { dato -> " - ${dato} \n" }
            .joinToString("")

    /*fun getListaAsignaturasBonica(lista:List<String>):String{
        var texto:String = ""
        for (asignatura in lista){
            //texto += " - " + asignatura + "\n" //COMO EN JAVA
            texto += " - $asignatura \n" //EN KOTLIN
        }

        return texto
    }*/



}