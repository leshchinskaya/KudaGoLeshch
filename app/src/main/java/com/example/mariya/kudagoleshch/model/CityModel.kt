package com.example.mariya.kudagoleshch.model

import java.io.Serializable

class CityModel : Serializable {
    var slug: String
    var name: String

    constructor(slug: String, name: String) {
        this.slug = slug
        this.name = name
    }
}