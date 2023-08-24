# clubSimulation

•	The start button initiates the simulation for the program to start, by pressing start you trigger a condition on command, the start flag is initially set to false but when the start button is pressed, the condition is set to true, while the pause button is set to false, and this notifies threads to start running.
•	The pause button pauses the simulation, pressing the button triggers a condition on command, the start flag is initially set to false but when the button is pressed, the condition is set to true, which sets the start button to false, this allows the threads to be set to sleep and stop where they are on the simulation, to resume the simulation press the start button, this will wake up the threads and allow the simulation to continue.

in **clubSimulation** we modified
atomic boolean variables
![Screenshot (4)](https://github.com/thbang25/clubSimulation/assets/83241507/e4491b18-6fee-41e5-9221-916fae883f64)

used it to improve the start and pause button
![Screenshot (1)](https://github.com/thbang25/clubSimulation/assets/83241507/bb599e59-32c3-4405-9626-fe91ce52beef)
![Screenshot (2)](https://github.com/thbang25/clubSimulation/assets/83241507/a1ecd928-67bd-4309-ad47-08b45923d4b5)

then created getters for the buttons
![Screenshot (3)](https://github.com/thbang25/clubSimulation/assets/83241507/5ceffa4b-46b4-4ee0-a7d4-495bc75b22b2)

in **clubgoers** we modified startsim() and checkPause()
![Screenshot (5)](https://github.com/thbang25/clubSimulation/assets/83241507/f31371fb-3969-4342-bd25-609d20093e7e)


•	There are club rules inside that patrons must enter through the entrance and exit doors. One patron accesses the entrance and exit doors at a time. The maximum number of patrons inside the club must not exceed a specified limit, Patrons must wait if the club limit is reached, or the entrance door is occupied by accessing the people counter class, The person entered method must be monitored we first need to check if the capacity has been reached before letting anyone in if the club is full we ask patrons to please wait if someone exits the club and there is availability we notify the patrons waiting and allow them in one by one according to the available capacity.

in the **peopleCounter** class 
![Screenshot (6)](https://github.com/thbang25/clubSimulation/assets/83241507/5b825267-edef-4433-8d6b-ec303c9b6a48)


