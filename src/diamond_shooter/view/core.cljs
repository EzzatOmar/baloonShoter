(ns diamond-shooter.view.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [diamond-shooter.view.components :refer [text view touchable-highlight alert]]
            [diamond-shooter.events]
            [diamond-shooter.subs]))

(defn start-screen []
  (let [{:keys [title]} @(subscribe [:get-start-screen])]
    [view {:style {:flex 1}}
     [view {:style {:background-color "red"
                    :flex 2
                    :justify-content "center"
                    :align-items "center"}}
      [text {:style {:font-size 30 :font-weight "500" :margin-bottom 20 :text-align "center"}} title]]
     [view {:style {:background-color "green"
                    :flex 3
                    :justify-content "center"
                    :align-items "center"}}
      [touchable-highlight {:style {:background-color "#539" :padding 20 :border-radius 5}
                            :on-press #(dispatch [:change-screen :game-screen])}
       [text {:style {:color "white" :text-align "center" :font-weight "bold" :font-size 30}} "START"]]
      ]
     ]))

(defn error-screen
  ([] (error-screen nil))
  ([msg] [view [text (str "Error: " msg)]]))

(defn root-view []
  (let [screen (subscribe [:get-current-screen])]
    (condp = @screen
      :start-screen [start-screen]
      :game-screen [error-screen "game"]
      [error-screen])
    ))

