package com.example.mariya.kudagoleshch.model.entity.eventEntity

data class Events(
        val count: Int,
        val next: String,
        val previous: Any,
        val results: List<Result>
)