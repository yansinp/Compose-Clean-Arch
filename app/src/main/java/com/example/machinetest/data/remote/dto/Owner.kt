package com.example.machinetest.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String?,
    @Json(name = "events_url")
    val eventsUrl: String? = null,
    @Json(name = "followers_url")
    val followersUrl: String? = null,
    @Json(name = "following_url")
    val followingUrl: String? = null,
    @Json(name = "gists_url")
    val gistsUrl: String? = null,
    @Json(name = "gravatar_id")
    val gravatarId: String? = null,
    @Json(name = "html_url")
    val htmlUrl: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "login")
    val login: String? = null,
    @Json(name = "node_id")
    val nodeId: String? = null,
    @Json(name = "organizations_url")
    val organizationsUrl: String? = null,
    @Json(name = "received_events_url")
    val receivedEventsUrl: String? = null,
    @Json(name = "repos_url")
    val reposUrl: String? = null,
    @Json(name = "site_admin")
    val siteAdmin: Boolean? = null,
    @Json(name = "starred_url")
    val starredUrl: String? = null,
    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "url")
    val url: String? = null
) : Parcelable