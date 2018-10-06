(ns diamond-shooter.db
  (:require [clojure.spec.alpha :as s]))

;; spec of app-db
(s/def ::title string?)
(s/def ::start-screen (s/keys :req-un [::title]))
(s/def ::valid-screens #{:start-screen :game-screen})
(s/def ::current-screen ::valid-screens)
(s/def ::app-db
  (s/keys :req-un [::start-screen
                   ::current-screen]))

;; initial state of app-db
(def start-screen {:start-screen {:title "DIAMOND SHOOTER"}})
(def current-screen {:current-screen :start-screen})
(def app-db (merge
             start-screen
             current-screen))
