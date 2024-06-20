(ns app.task)

(defn *list 
  "define a node of to do list with a map"
  ([]
   {:id 0
    :description "null" 
    :status "null"}
   )
  ([x y z]
   {:id x
    :description y
    :status z}))

(defn add-list [list])

(defn list_tasks [list]
  (when (not (empty? list))
  (println list)))
