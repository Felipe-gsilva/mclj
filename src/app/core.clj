(ns app.core
  (:require 
    [com.moclojer.adapters :as adapters]
    [com.moclojer.server :as server]))

(fn foo
  "returns the first element of an array"
  [arr]
  (println (nth arr 0))
  )

(defn router [some-shit] 
  (adapters/generate-routes
    [{:endpoint
      {:method "GET" 
       :path "/hello-world"
       :response {:status 200
                  :headers{:Content-Type "application.json"}
                  :body {:id some-shit}}}}])
  )

(defn -main
  "main func"
  [& args]
  (println (count args))
  )

