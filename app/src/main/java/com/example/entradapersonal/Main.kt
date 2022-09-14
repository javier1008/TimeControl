package com.example.entradapersonal

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
val employee=Employee(18920012,"Javier Iván Aquino Macés",
AcademicLevel.BACHELOR,"AUMJ000810HOCQCVA6",
    LocalDate.parse("2022-10-25"),"550089")
    val period=Period(LocalDate.parse("2022-10-26"),LocalDate.parse("2022-07-15"),
    "Primera Quincena de Septiembre")

    val Schedule=Schedule.Builder(employee,period)
        .addOne(Schedule.Detail(DayOfWeek.MONDAY,
            LocalTime.of(8,0),LocalTime.of(14,0)))
        .addOne(Schedule.Detail(DayOfWeek.THURSDAY,
            LocalTime.of(9,0),LocalTime.of(15,0)))
        .build()
    val CheckInOut=CheckInOut(LocalDate.parse("2022-10-25"),employee,
        LocalTime.of(8,11),LocalTime.of(14,0))
    val permission=Permission(employee,LocalDate.parse("2022-07-01"),
        "Fallecimiento de la Reyna Isabel")

    //val Incident=Incident(employee,Schedule,)
}