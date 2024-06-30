(ns dev.core 
  (:require 
    [com.moclojer.adapters :as adapters]
    [com.moclojer.server :as server]
    [dev.task :as task]))

(def *router  
  "creating an adapter example, even dough  the .yml on resources has some endpoints tests"
  (adapters/generate-routes
    [{:endpoint {:method "GET" 
                 :path "/list-tasks"
                 :response {:status 200
                            :headers {:Content-Type "application/json"}
                            :body {:tasks (task/list-tasks)}}}}
     {:endpoint {:method "POST" 
                 :path "/create-task" 
                 :response {:status 200 
                            :headers {:Content-Type "application/json"}
                            :body {:task-created (task/create-task (body.desc) (body.stat))}}}} 
     {:endpoint {:method "DELETE" 
                 :path "/delete-task" 
                 :response {:status 200
                            :headers {:Content-Type "application/json"
                                      :body {:id (task/remove-task (body.id))}}}}} ;need input
     {:endpoint {:method "DELETE" 
                 :path "/delete-all" 
                 :response {:status 200
                            :headers {:Content-Type "application/json"
                                      :body {:tasks (task/delete-all)}}}}}
     {:endpoint {:method "PUT" 
                 :path "/update-task" 
                 :response {:status 200 
                            :headers {:Content-Type "application/json"}
                            :body {:task-created (task/update-task (body.id) (body.desc) (body.stat))}}}} 
     ]))

(defn start! 
  "starting the server"
  ([]
   (server/start-server! *router)) 
  ([config-path] 
   (server/start-server-with-file-watcher! {:config-path config-path})))

(defn -main
  "main function for this little project"
  []
  (start!)) ;
