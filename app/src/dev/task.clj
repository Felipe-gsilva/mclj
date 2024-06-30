(ns dev.task)

(def tasklist (atom []))

(defn add-to-list [task]
  (swap! tasklist conj task))

(defn list-tasks [] (println @tasklist))

(defn create-task [desc stat] 
  (let [carlos {:id (inc (count @tasklist)) :status stat :description desc}]
    (add-to-list carlos)))

(defn remove-task [id]
 (swap! tasklist (fn [tasks] (remove #(= (:id %) id) tasks))))

(defn update-task [id desc stat]
  (swap! tasklist (fn [tasks] (assoc (nth tasks id) :description desc :status stat))))

(defn delete-all [] (reset! tasklist [{}]))

(defn list-ops 
  "operations listed"
  []
  (println "select what to do:")
  (println "1 - create task")
  (println "2 - list tasks")
  (println "3 - delete a task")
  (println "4 - update a task")
  (println "9 - delete all")
  (println "0 - exit"))

(defn start! 
  "project cli for local tests"
  []
  (list-ops) 
  (let [op (Integer/parseInt (read-line))]
    (cond 
      (= op 0) (do 
                 (println "exiting..")
                 (System/exit 0))
      (= op 1) (do
                 (println "CREATING A TASK")
                 (println "write the description:")
                 (let [desc(read-line)]
                   (println "write the status")
                   (let [stat (read-line)]
                     (create-task desc stat)))
                 ) 
      (= op 2) (list-tasks) 
      (= op 3) (do
                 (println "select the id to remove:") 
                 (let [id (Integer/parseInt (read-line))]
                   (remove-task id)))
      (= op 4) (do
                 (println "select the id to update") 
                 (let [id (Integer/parseInt (read-line))]
                   (println "type the new description")
                   (let [desc (read-line)]
                     (println "type the new status")
                     (let [stat (read-line)]
                       (update-task id desc stat)))))
      (= op 9) (delete-all)
      :else (println "not valid input")))
  (start!))

(defn -main 
  "starting point" 
  []
  (start!))
