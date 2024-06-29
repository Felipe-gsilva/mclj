(ns dev.core 
  (:require 
    [com.moclojer.adapters :as adapters]
    [com.moclojer.server :as server]
    [dev.task :as task]))

(def *router  
  "creating an adapter"
  (adapters/generate-routes
    [{:endpoint
      {:method "GET" 
       :path "/list-tasks"
       :response {:status 200
                  :headers {:Content-Type "application/json"}
                  :body {:tasks (task/list-tasks)}}}}
     {:endpoint {:method "POST" 
                 :path "/create-task" 
                 :response {:status 200 
                            :headers {:Content-Type "application/json"}
                            :body {:task-created (task/create-task "carlos" "carlos")}}}}
     {:endpoint {:method "DELETE" 
                :path "/delete-task" 
                :response {:status 200
                           :headers {:Content-Type "application/json"
                                     :body {:id (task/remove-task 1)}}}}}
     {:endpoint {:method "DELETE" 
                :path "/delete-all" 
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
  [& args]
  (start!)
  (task/start!))
