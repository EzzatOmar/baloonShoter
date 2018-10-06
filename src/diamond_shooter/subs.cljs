(ns diamond-shooter.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :get-current-screen
  (fn [db _]
    (:current-screen db)))

(reg-sub
 :get-start-screen
 (fn [db _]
   (:start-screen db)))
