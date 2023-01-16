package gooder.shared.network

import gooder.shared.core.apiresult.ApiResult
import gooder.shared.network.api.GooderNetworkDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom

class GooderNetworkClient(
    private val client: HttpClient,
) : GooderNetworkDataSource {

    override suspend fun genres(): ApiResult<List<String>> {
        val response = client.get {
            url {
                takeFrom("https://api.vavkhan.com")
                encodedPath = "/book/genres"
            }
        }
        return when (response.status.value) {
            in HttpStatusCode.OK.value..HttpStatusCode.MultipleChoices.value -> ApiResult.Success(response.body())
            else -> ApiResult.Failure(
                code = response.status.value,
                message = response.status.description,
                throwable = ServerResponseException(response, response.bodyAsText())
            )
        }
    }
}
