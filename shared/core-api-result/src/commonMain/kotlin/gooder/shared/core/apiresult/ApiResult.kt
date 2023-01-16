package gooder.shared.core.apiresult

sealed class ApiResult<out T> {

    data class Success<T>(
        val value: T,
    ) : ApiResult<T>()

    data class Failure(
        val code: Int,
        val message: String,
        val throwable: Throwable
    ) : ApiResult<Nothing>()
}
