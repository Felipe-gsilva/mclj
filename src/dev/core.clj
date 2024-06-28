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
                  :headers{:Content-Type "application/json"}
                  }}}]))

(defn start! 
  "starting the server"
  ([]
    (server/start-server! *router)) 
  ([config-path] 
   (server/start-server-with-file-watcher! {:config-path config-path})))

(defn -main
  "main function for this little project"
  [& args]
  (println (count args))
  (task/start!))
  (start! "resources/moclojer.yml")

