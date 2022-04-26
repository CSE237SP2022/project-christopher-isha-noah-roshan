# project-christopher-isha-noah-roshan
#### Project Description

Our project is a weather app for Honolulu, HI. Our program is able to show actual and predicted temperatures and precipitation for a given date or 7-day range.

#### What user stories were completed this iteration?

In this iteration we focused on providing the user with weather data for a 7-day range. To do so we accomplished the following:
* Allowing the user to choose between seeing weather for a single date or a 7-day range
* Displaying the temperatures and precipitation for each day in a chosen 7-day range
* Displaying the average temperatures and total precipitation over a chosen 7-day range

#### Is there anything that you implemented but doesn't currently work?

We do have a small bug when calculating total precipitation over a 7-day range. The preciptation data we are using is in a year-to-date format so we calculate total precipitation over a range by subtracting the precipitation value of the first day in the range from that of the last day in the range. This method works in every scenario except for one in which a new year begins within the 7-day range. In these cases, the total precipitation calculations will be incorrect as the precipitation data gets reset to zero at the start of a new year. All other code is functional and provides accurate data and calculations.

#### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
After cloning and entering the repository on the command line, run the provided script:
* ./WeatherApp.sh

