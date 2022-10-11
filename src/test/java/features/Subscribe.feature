Feature: Subscribe Form
  			 I want to verify the fields of Subscribe form

@SmokeTest
Scenario: Verification of all the fields of Subscribe form
    			Given I navigate to the PwC Digital Pulse website
					And I am viewing the 'Home' page
					When I click on the 'Subscribe' navigation link
					Then I am taken to the 'Subscribe' page
					And I am presented with the below fields

      		| Field 								 | Required  | Type 		|
					|	First name 						 |		true 	 | text 		|
					| Last name 						 | 		true 	 | text 		|
					| Organisation					 |		true 	 | text 		|
					| Job title  						 |		true 	 | text			|
					| Business email address | 		true 	 | email		|
					|	State 							   |		true	 | dropdown |
					|	Country							   |		true	 | dropdown |
					And I will need to complete Google reCAPTCHA before I can complete my request