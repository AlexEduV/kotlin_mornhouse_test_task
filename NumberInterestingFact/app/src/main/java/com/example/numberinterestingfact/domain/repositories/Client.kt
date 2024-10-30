package com.example.numberinterestingfact.domain.repositories

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

const val apiEndPoint: String = "http://numbersapi.com/"

suspend fun fetchData(number: String): String {

    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("$apiEndPoint$number")
    val responseBody: String = response.bodyAsText()
    client.close()

    return responseBody
}