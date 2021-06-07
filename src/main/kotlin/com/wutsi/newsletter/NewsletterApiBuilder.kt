package com.wutsi.newsletter

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Request
import feign.RequestInterceptor
import feign.Retryer
import kotlin.collections.List

public class NewsletterApiBuilder {
  public fun build(
    env: Environment,
    mapper: ObjectMapper,
    interceptors: List<RequestInterceptor> = emptyList(),
    options: Request.Options = Request.Options(),
    retryer: Retryer = Retryer.Default()
  ) = feign.Feign.builder()
    .client(feign.okhttp.OkHttpClient())
    .encoder(feign.jackson.JacksonEncoder(mapper))
    .decoder(feign.jackson.JacksonDecoder(mapper))
    .logger(feign.slf4j.Slf4jLogger(NewsletterApi::class.java))
    .logLevel(feign.Logger.Level.BASIC)
    .requestInterceptors(interceptors)
    .options(options)
    .retryer(retryer)
    .target(NewsletterApi::class.java, env.url)
}
