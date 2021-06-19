package com.yajatmalhotra.catnip.model

data class CatFact(
    val __v: Int = 0,
    val _id: String = "",
    val createdAt: String = "",
    val deleted: Boolean = false,
    val source: String = "",
    val status: Status = Status(),
    val text: String = "Please connect to the internet :)",
    val type: String = "",
    val updatedAt: String = "",
    val used: Boolean = false,
    val user: String = ""
)
