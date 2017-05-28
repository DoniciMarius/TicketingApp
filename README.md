# TicketingApp
  This is a Spring Boot application.
  
  A RESTful Web Service for a ticketing system.
  
  The webserver I have used was Tomcat.
  
  
# REST Implementation
  For the REST implementation I have used JAX-RS.
  
  I could have used the Spring REST.
  
  Endpoints:
  
  EVENT ENDPOINTS:
  
     /event             POST      - create an event
     /event/dummy       GET       - get a representation of the Event object
     /event/{id}        PUT       - update an event
     /event/list_events GET       - get a list of all the events
     /event/{id}        GET       - get the event with the id
     /event/{id}        DELETE    - remove the object with the id
     
  TICKET ENDPOINTS:
  
     /ticket/buy_ticket   POST    - buys a new ticket(creates) THE POST SHOULD BE ON THE /ticket instead of /ticket/buy_ticket 
     /ticket/dummy        GET     - get a representation of the Ticket object
     /ticket/details/{id} GET     - get the ticket with the id
     /ticket/cancel/{id}  DELETE  - cancels the ticket with the id
  
  The content-type for the requests is application/json
  
# Database 
  As my database I have used a Postgres database.
  
  For database connection and interrogations I used Hibernate.
  
  My application has 2 entities Ticket and Event.
  
  
# Tests
  I tested the cancel ticket functionality.
  
  I used Mockito framework to mock the daos and the services.
