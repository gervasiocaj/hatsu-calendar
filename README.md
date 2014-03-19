# Hatsu Calendar

This is an implementation for a RESTful calendar API using JAX-RS. The objects are stored in the memory, and lost when the program is stopped. This is part of the Cloud Computing module assignment, and the group is formed by
    Gervasio Costa, D13123897 and Stephen Hanley, C08364275.
Dublin Institute of Technology, 2014, semester two.

## Example of instance

http://hatsu-calendar.herokuapp.com/services/calendar

    {
        "-131060131" : {
            "owner":"john",
            "entries" : [
                {
                    "location":"NONE",
                    "description":"meeting with sarah",
                    "dateStart":1321023600000,
                    "dateEnd":1321027200000,
                    "repetition":"NONE",
                    "repeats":0
                }
            ]
        }
    }

## Using the application

There is an instance of the current version running at http://hatsu-calendar.herokuapp.com/services/calendar

###GET:
    http://hatsu-calendar.herokuapp.com/services/calendar : all calendars in memory
    http://hatsu-calendar.herokuapp.com/services/calendar/{id} : the calendar specified by such {id}
    http://hatsu-calendar.herokuapp.com/services/calendar/{id}/event : all events the {id} calendar contains
    http://hatsu-calendar.herokuapp.com/services/calendar/{id}/event/{code} : the {code} event inside {id} calendar

###POST:
    http://hatsu-calendar.herokuapp.com/services/calendar?owner=john : create calendar with owner equal to 'john'
    http://hatsu-calendar.herokuapp.com/services/calendar/{id}/event?desc=meeting with sarah&start=2011-11-11 15:00&end=2011-11-11 16:00 : add event to calendar identified by {id}
    



