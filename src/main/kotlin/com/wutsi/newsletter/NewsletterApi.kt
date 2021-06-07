package com.wutsi.newsletter

import feign.Headers
import feign.Param
import feign.RequestLine
import java.time.LocalDate
import kotlin.Long
import kotlin.Unit

public interface NewsletterApi {
  @RequestLine("GET /v1/newsletter/share?story-id={story-id}")
  @Headers("Content-Type: application/json")
  public fun share(@Param("story-id") storyId: Long): Unit

  @RequestLine("GET /v1/newsletter/digest?start-date={start-date}&end-date={end-date}")
  @Headers("Content-Type: application/json")
  public fun digest(@Param("start-date") startDate: LocalDate, @Param("end-date")
      endDate: LocalDate): Unit
}
