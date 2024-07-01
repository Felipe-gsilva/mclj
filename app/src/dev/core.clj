(ns dev.core 
  (:require 
    [com.moclojer.adapters :as adapters]
    [com.moclojer.server :as server]
    [dev.task :as task]))

(def *router  
  "creating an adapter example, even dough  the .yml on resources has some endpoints tests"
  (adapters/generate-routes
    [{:endpoint {:method "GET" 
                 :path "/tasks"
                 :response {:status 200
                            :headers {:Content-Type "application/json"}
                            :body {:tasks (task/list-tasks)}}}}
     {:endpoint {:method "POST" 
                 :path "/task" 
                 :response {:status 200 
                            :headers {:Content-Type "application/json"}
                            :body {:task-created (task/create-task "desc-1-example" "stat-1-example")}}}} 
     {:endpoint {:method "DELETE" 
                 :path "/task/" 
                 :response {:status 200
                            :headers {:Content-Type "application/json"
                                      :body {:id (task/remove-task 1)}}}}}
     {:endpoint {:method "DELETE" 
                 :path "/tasks" 
                 :response {:status 200
                            :headers {:Content-Type "application/json"
                                      :body {:tasks (task/delete-all)}}}}}
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
