package gooder.shared.network.api

import gooder.shared.core.apiresult.ApiResult

interface GooderNetworkDataSource {

    suspend fun genres(): ApiResult<List<String>>
}
