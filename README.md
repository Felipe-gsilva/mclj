# app

A simple project made with clojure trying to understand the basics, while adding the mock service Moclojer into it;

Basically, Im using svelte to create a simple dynamic page to render the mock tests written on clojure, so you must need some techs to run this project.
Firstly, install [java](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html), [clojure](https://clojure.org/guides/install_clojure) and [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).

Simply run, then:

for the mock server
> cd app/ && clj -M:dev -m dev.core

for the frontend
> cd front && npm install && npm run dev

---

You can also simply use docker or docker compose to run this project.

Run:
> docker compose build 

and then

> docker compose up

--- 
# Ports

- localhost:5173 `frontend`
- localhost:8000 `mock server`
### endpoints
> list-tasks

> create-task

> delete-all

> delete-task

> update-task

