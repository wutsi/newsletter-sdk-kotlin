package com.wutsi.newsletter

import feign.Param
import feign.RequestLine
import kotlin.Long
import kotlin.Unit

public interface NewsletterApi {
  @RequestLine("GET /v1/newsletter/share")
  public fun share(@Param("story-id") storyId: Long): Unit
}
