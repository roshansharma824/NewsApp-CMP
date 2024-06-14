package com.exmaple.newsapp.domain.model

import com.exmaple.newsapp.domain.model.Multimedia
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("abstract")
    val `abstract`: String?,

    @SerialName("byline")
    val byline: String?,

    @SerialName("created_date")
    val created_date: String?,

    @SerialName("des_facet")
    val des_facet: List<String>?,

    @SerialName("geo_facet")
    val geo_facet: List<String>?,

    @SerialName("item_type")
    val item_type: String?,

    @SerialName("kicker")
    val kicker: String?,

    @SerialName("material_type_facet")
    val material_type_facet: String?,

    @SerialName("multimedia")
    val multimedia: List<Multimedia>?,

    @SerialName("org_facet")
    val org_facet: List<String>?,

    @SerialName("per_facet")
    val per_facet: List<String>?,

    @SerialName("published_date")
    val published_date: String?,

    @SerialName("section")
    val section: String?,

    @SerialName("short_url")
    val short_url: String?,

    @SerialName("subsection")
    val subsection: String,

    @SerialName("title")
    val title: String?,

    @SerialName("updated_date")
    val updated_date: String?,

    @SerialName("uri")
    val uri: String?,

    @SerialName("url")
    val url: String?
)