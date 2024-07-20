# Tasklist on clojure

A simple project made with clojure trying to understand the basics, while adding the mock service Moclojer into it.

It is a simple tasklist manager, using a atom to store the data on `dev.task` namespace and storing each entry as maps with 3 keys: id, description and status.
Id is a number generated automatically by counting the number of differents tasks and increasing one to make the indexing 1 based. Also, the description and status relies on any data added into it, such as strings or numbers or even seq vars.

### functions implemented

This project has a simple CLI to show the output of the task manager, so you can use `clj -M:dev -m dev.task` to test the functional implementation of a tasklist. The main functions displayed are:
- list-tasks, which simply print the derreferenced atom
- create-task, receives 2 inputs stored on runtime by the let function and sent by the json body request (for now, the value received on the body request is actually static and not changed by the input on svelte fronted input) and add it with swap! function on the atom.
- delete-task, receives an Id and removes the map with matching id using an anonymous func and remove function.
- delete-all, simply reset! the atom tasklist value as an empty arr.
- update-task, receives an Id, a desc and a status, access the map by using nth funciton and assoc the new values on the scope map returned. Then, the anonymous funcion return the altered map to the swap! function and alter the atom.

---
# Running the project

Basically, I'm using Svelte to create a simple dynamic page to render the mock tests written on clojure, so you must need some techs to run this project.
Firstly, install [java](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html), [clojure](https://clojure.org/guides/install_clojure) and [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).

for the mock server, run this command
> cd app/ && clj -M:dev -m dev.core

then, for the frontend
> cd front && npm install && npm run dev

---

You can also simply use docker or docker compose to run this project. Although this project is really small, I thought it would be a great ideia to implement some simple Dockerfiles and use the docker-compose.yml to automate the compiling and testing processes.

Run:
> docker compose build 

and then

> docker compose up

--- 
# Ports
The ports available are these two
- localhost:5173 `frontend`
- localhost:8000 `mock server`

### endpoints
These endpoints actually return the functions implemented on the clojure `ns dev.task` but statically. The main idea was to make the project dynamic, but I couldn't find a way to receive the json params out of the render template on yml and I could realize that Moclojer does not yet can handle dynamic returns by testing different inputs on the same runtime. I realized, also, that the renderer template, when altered on local drive, is immediatly rebuilt on the project as it goes, easing the experience and kind of making the under the hood process seemsly.

> tasks | GET

> task | POST

> tasks | DELETE

> task | DELETE

> task | PUT

