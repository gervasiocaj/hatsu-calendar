# Hatsu Calendar

This is an implementation for a RESTful calendar API using JAX-RS. The objects are stored in the memory, and lost when the program is stopped. This is part of the Cloud Computing module assignment, and the group is formed by
    Gervasio Costa, D13123897 and Stephen Hanley, C08364275.
Dublin Institute of Technology, 2014, semester two.

## Example of instance

http://hatsu-calendar.herokuapp.com/services/calendar

    {
        "-131060131" : {
            "owner":"gervasio",
            "entries" : [
                {
                    "location":"NONE",
                    "description":"'festa duro'",
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

###POST
    todo



