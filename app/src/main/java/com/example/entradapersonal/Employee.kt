package com.example.entradapersonal

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

data class Employee (
    val id: Long,
    val fullName:String,
    val academicLevel: AcademicLevel,
    val curp:String,
    val dateOfAdmission: LocalDate,
    val budgetKey: String
)
    //val numero3:Int =3
{
    @RequiresApi(Build.VERSION_CODES.O)
    fun getSeniority():Int{
        val currentYear = LocalDate.now().year //Obtiene el año actual
        val currentMonth = LocalDate.now().monthValue //Obtiene el mes actual
        val currentDay = LocalDate.now().dayOfMonth //Obtiene el día actual
        val yearOfAdmission = dateOfAdmission.year //Obtiene el año de admisión
        val monthOfAdmission = dateOfAdmission.monthValue //Obtiene el mes de admisión
        val dayOfAdmission = dateOfAdmission.dayOfMonth //obtiene el día de admisión

        val year = currentYear - yearOfAdmission //La resta del año actual menos el admisión
        //Se hace una validación exacta sobre el tiempo que lleva de trabajo contemplando mes y día
        return (if (currentMonth<monthOfAdmission ||
            (currentMonth==monthOfAdmission && currentDay<dayOfAdmission ))
            year - 1
        else
            year)
    }

    fun getGenre()=curp.substring(10,11) //Extrae el caracter correspondiente al genero en la CURP
}