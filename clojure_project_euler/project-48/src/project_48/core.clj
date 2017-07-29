(ns project-48.core
  (:require
   [clojure.math.numeric-tower :refer [expt]]))

(defn -main [& args]
  (letfn [(last-n [n s] (subs s (- (count s) n)))]
    (println
     (last-n 10
      (str
       (transduce
        (comp
         (map (partial repeat 2))
         (map (partial apply expt)))
        + (range 1 1001)))))))
