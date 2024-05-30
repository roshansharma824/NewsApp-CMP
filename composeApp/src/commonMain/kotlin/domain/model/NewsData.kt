package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsData(
    @SerialName("copyright")
    val copyright: String?,

    @SerialName("last_updated")
    val last_updated: String?,

    @SerialName("num_results")
    val num_results: Int?,

    @SerialName("results")
    val results: List<Result>?,

    @SerialName("section")
    val section: String?,

    @SerialName("status")
    val status: String?
)