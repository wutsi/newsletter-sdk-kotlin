package com.wutsi.newsletter

import kotlin.String

public enum class Environment(
  public val url: String
) {
  SANDBOX("https://wutsi-newsletter-test.herokuapp.com"),
  PRODUCTION("https://wutsi-newsletter-prod.herokuapp.com"),
  ;
}
