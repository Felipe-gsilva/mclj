(ns app.core
  (:require 
    [com.moclojer.adapters :as adapters]
    [com.moclojer.server :as server]
    [app.task :as a]))

(def *router  
  "creating an adapter"
  (adapters/generate-routes
    [{:endpoint
      {:method "GET" 
       :path "/hello-world"
       :response {:status 200
                  :headers{:Content-Type "application/json"}
                  :body {:id 123}}}}
     {:endpoint
      {:method "POST" 
       :path "/login" 
       :response 
       {:status 200 
        :headers 
        {:Content-Type "application/json" 
         :body{:id 123}}}}}]))

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
  (let [x 0]
    (a/list-tasks list)
  )
  (start! "resources/moclojer.yml"))

