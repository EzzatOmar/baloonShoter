(ns diamond-shooter.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [diamond-shooter.view.core :refer [root-view]]
            [diamond-shooter.events]
            [diamond-shooter.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))


(defn alert [title]
      (.alert (.-Alert ReactNative) title))

(defn app-root []
  (root-view)
  )

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "diamondShooter" #(r/reactify-component app-root)))
