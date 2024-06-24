(ns app.task)

(def tasklist (atom [{:id 0 :status "nil" :description "nil"}]))

(defn add-to-list [task]
  (swap! tasklist conj task))

(defn list-tasks [] (println tasklist))

(defn create-task [desc status] 
  (let [carlos {:id (count @tasklist) :status status :description desc}]
    (add-to-list carlos)))

(defn start! 
  "trying to perform things"
  []
  (println "select what to do")
  (let [op (read-line)]
    (cond 
      (when (= op 0) 
        (System/exit 0))
      (when (= op 1)
        (println "teste"))
      (when (= op 2)
        (create-task (read-line)(read-line)))
      (when (= op 3)
        (list-tasks)))))


(defn -main 
  "our starting point" 
  []
  (println "carlos")
  (start!)
  (list-tasks))
