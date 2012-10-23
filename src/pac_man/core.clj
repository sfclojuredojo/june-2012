(ns pac-man.core
  (require [clojure.main :as main]))

;walls w
;empty space s
;cherries c
;ghosts g
     ;scared?
;pac-man p
     ;direction
         ;one of four
     ;mouth open or closed

;; true means there is a wall
;; false means pac man or a ghost or a cherry can occupy the space
(def maze [[true  true  true  true  true true]
           [true false false false false true]
           [true false false false false true]
           [true false false false false true]
           [true false false false false true]
           [true  true  true  true  true true]])

(def start-pac-man {:pos [0 0]
                    :dir :s
                    :open true})

(def update-ghost [])

(def dir-map
{:n [0 -1]
 :s [0 1]
 :e [1 0]
 :w [-1 0]})

(defn vadd [pvec avec]
  (map + pvec avec))

(defn next-pos [pos dir]
  (vadd pos dir))

(defn update-pacman [pac-man last-user-direction]
  {:pos (let [new-position (vadd (:pos pac-man) (last-user-direction dir-map))]
          (if (get-in maze new-position) ;true means a wall
            (:pos pac-man) ;old pac-man position because no move available
            new-position))
   :dir last-user-direction
   :open (not (:open pac-man))
   })

;(defn quit? [pac-man]
;  (if)
;  )

;playing with repl function
(defn start-repl []
  (main/repl))

(defn -main
  "I do everything!!!"
  [& args]
  (println "start pacman")
  (loop [pac-man start-pac-man
         ghosts start-ghosts
         cherries start-cherries]
    (if (quit? pac-man)
      nil
      (recur (update-pacman pac-man (poll-repl)))
      )
    ))

