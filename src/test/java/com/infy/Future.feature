Feature: Negative Future Response
Scenario: Response Validation3
Given API for foreign exchanges 
When posted with future date information
Then validate positive response code receivedd

Examples:
				|  date    |
				|2020-12-12|
        |2020-12-07|
        |2021-10-10|