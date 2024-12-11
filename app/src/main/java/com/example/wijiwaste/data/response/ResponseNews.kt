package com.example.wijiwaste.data.response

import com.google.gson.annotations.SerializedName

data class ResponseNews(

	@field:SerializedName("important")
	val important: String,

	@field:SerializedName("pagination")
	val pagination: Any,

	@field:SerializedName("posts")
	val posts: List<PostsItem>,

	@field:SerializedName("featured_post")
	val featuredPost: FeaturedPost,

	@field:SerializedName("status")
	val status: Int
)

data class PostsItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("premium_badge")
	val premiumBadge: String,

	@field:SerializedName("pusblised_at")
	val pusblisedAt: String,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("headline")
	val headline: String
)

data class FeaturedPost(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("pusblised_at")
	val pusblisedAt: String,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("image_desc")
	val imageDesc: String,

	@field:SerializedName("headline")
	val headline: String
)
