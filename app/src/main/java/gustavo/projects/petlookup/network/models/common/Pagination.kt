package gustavo.projects.petlookup.network.models.common

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count_per_page")
    var countPerPage: Int,
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("current_page")
    var currentPage: Int,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("_links")
    var links: Links,
)
