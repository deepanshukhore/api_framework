Feature: Validating Place API
@AddplaceAPI
Scenario: Verify if place is being Successfully added using AddPlaceAPI
Given ADD place PayLoad
When  user calls "AddPlaceAPI" Method With Post http Api
Then  the API call is sucess with status code 200
And "status" in responce body is "OK"
And "scope" in responce body is "App"