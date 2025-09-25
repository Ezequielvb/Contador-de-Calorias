package com.example.contador_calorias

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class registro(
    val elemento: String,
    val calorias: Int?,
    val porciones: Int?

)

fun pintar(list: List<registro>):String{
    var lista:String = ""
      list.forEach {
            item -> lista += "${item.elemento},${item.calorias},${item.porciones}\n"


    }
    return lista

}
@Composable
fun ContadorCalorias(){
    Column {
        Text(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top= 30.dp, bottom = 15.dp),
            text = "Contador de \nCalorías",
            color = Color.Cyan
        )
        var element by remember { mutableStateOf("") }
        OutlinedTextField(
            value = element,
            onValueChange = { newelement -> element = newelement },
            label = { Text("Elemento") },
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp, top = 5.dp),
            maxLines = 1
        )
        var calo by remember { mutableStateOf("") }
        OutlinedTextField(
            value = calo,
            onValueChange = { calo = it },
            label = {Text(text = "Calorías por porción")},
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp, top = 5.dp),
            maxLines = 1
        )
        var numPorc by remember { mutableStateOf("") }
        OutlinedTextField(
            value = numPorc,
            onValueChange = {numPorc = it},
            label = {Text(text = "Número de porciones")},
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp, top = 5.dp),
            maxLines = 1,
        )
        var lista = remember { mutableListOf<registro>() }

        var resul by remember { mutableStateOf("") }
        var pintar by remember { mutableStateOf(false) }
        Button(
            onClick = {
                var cal = calo.toIntOrNull()
                var por = numPorc.toIntOrNull()
                lista.add(registro(element,cal, por))
                val tot = (calo.toInt()*numPorc.toInt()).toString()
                 resul = "El total de calorias son: $tot kcal"
                pintar = false
            },
            modifier = Modifier.fillMaxWidth().padding(20.dp),



        ){
            Text(text = "Añadir")
        }
        Text(
            text = resul,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                pintar = true
            },
            modifier = Modifier.fillMaxWidth().padding(20.dp),



            ){
            Text(text = "Mostrar lista")
        }
        if(pintar == true) {

            Text(
                text = pintar(lista),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,

            )

        }




    }



}