package contracts

org.springframework.cloud.contract.spec.Contract.make {
    description("When a GET request is made, the Employee object is returned")
    request {
        method 'GET'
        url '/employee/'
    }
    response {
        status 200
        body("""
  {
    "id": "1",
    "name": "Jane"
  }
  """)
        headers {
            contentType(applicationJson())
        }
    }
}