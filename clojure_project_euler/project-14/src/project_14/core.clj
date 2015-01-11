(ns project-14.core)

(defn next-num [n]
  (if (even? n)
    (/ n 2)
    (inc (* 3 n))))

(def collatz-seq
  (memoize
   (fn [seed]
     (cons
      seed
      (when-not (= 1 seed)
        (lazy-seq (collatz-seq (next-num seed))))))))

(defn -main [& args]
  (->> (range 1 1000000)
       (map (juxt identity (comp count collatz-seq)))
       (apply max-key second)
       first
       println))