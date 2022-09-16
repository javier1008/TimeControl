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

val period=Period(LocalDate.parse("2022-10-01"),
                      LocalDate.parse("2022-10-15"),
                     "Primera Quincena de Septiembre")

val listScheduleDetails: ArrayList<Schedule.Detail> = arrayListOf(
    Schedule.Detail(DayOfWeek.MONDAY,
        LocalTime.of(8,0),LocalTime.of(14,0)),
    Schedule.Detail(DayOfWeek.THURSDAY,
        LocalTime.of(8,0),LocalTime.of(14,0)),
    Schedule.Detail(DayOfWeek.WEDNESDAY,
        LocalTime.of(8,0),LocalTime.of(14,0))
)

val schedule=Schedule.Builder(employee,period)
    .addMany(listScheduleDetails)
    .build()

val listCheckInOut= listOf<CheckInOut>(
    CheckInOut(LocalDate.parse("2022-10-10"),employee,
        LocalTime.of(8,0),LocalTime.of(14,0)),
    CheckInOut(LocalDate.parse("2022-10-11"),employee,
        LocalTime.of(8,0),LocalTime.of(14,0))
)
val listPermission= listOf<Permission>(
    Permission(employee,LocalDate.parse("2022-10-24"),
        "Fallecimiento de la Reyna Isabel")
)


println("La persona ${employee.fullName}" )
    //val Incident=Incident(employee,Schedule,)

    val incident = Incident(
        employee = employee,
        currentSchedule = schedule,
        checksInOut = listCheckInOut,
        permissions = listPermission,
        initialDate = LocalDate.parse("2022-10-01"),
        finalDate = LocalDate.parse("2022-10-15")
    )
    println("La persona ${employee.fullName}" + "Tiene ${incident.getAbsences()}" )

}