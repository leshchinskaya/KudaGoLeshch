package com.example.mariya.kudagoleshch.abstracts.entity

import android.media.Image
import java.time.LocalDate

class Event {
    var id : Long, // - идентификатор
    var publication_date : LocalDate, // - дата публикации
    var dates : Dates, // - даты проведения
    var title : String, // - название
    var short_title : String, // - короткое название
    var slug : String, // - слаг
    var place : String, // - место проведения
    var description : String, // - описание
    var body_text : String, // - полное описание
    var location : String, // - город проведения
    var categories : List<Category>, // - список категорий
    var tagline : String, // - тэглайн
    var age_restriction : String, // - возрастное ограничение
    var price : Int, // - стоимость
    var is_free : Boolean, // - бесплатное ли событие
    var images : Image, // - картинки
    var favorites_count : Int, // - сколько пользователей добавило событие в избранное
    var comments_count : Int, // - число комментариев к событию
    var site_url : String, // - адрес события на сайте kudago.com
    var tags : String, // - тэги события
    var participants : String // - агенты события

}