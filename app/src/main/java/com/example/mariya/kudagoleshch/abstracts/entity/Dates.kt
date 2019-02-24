package com.example.mariya.kudagoleshch.abstracts.entity

import java.sql.Time
import java.util.*

class Dates {
    var start_date : Date,
    var start_time : Time,
    var start : Long,
    var end_date : Date,
    var end_time : Time,
    var end : Long,
    var is_continuous : Boolean,
    var is_endless : Boolean,
    var is_startless : Boolean,
    var schedules : Array<String>,
    var use_place_schedule : Boolean
}