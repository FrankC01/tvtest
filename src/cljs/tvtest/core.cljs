(ns ^{:author "Frank V. Castellucci"
    :doc "Clojure and Clojurescript for Apple TVOS"}
  tvtest.core
  (:require-macros [hiccups.core :as hiccups :refer [html]])
  (:require [hiccups.runtime :as hiccupsrt]
            [clojure.walk :as w]))


;;
;; Apple Templates
;;

(def alert-template [:document [:alertTemplate]])

;;
;; Utility section
;;

(defonce xml-tag "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>")

(defn insert-at
  "Insert nodes at a point in the data
  coll - Current model
  targkw - which 'node' to insert at
  node - one node
  nodes - additional nodes"
  [coll targkw node & nodes]
  (w/postwalk
   (fn [x]
     (if (and (vector? x) (= (first x) targkw))
      [(first x)
       (conj nodes node)
       (second x)]
      x)) coll))

;;
;; Alert Handler
;;

(defn- tv-alert
  "Prepares the TV alertTemplate"
  [title desc]
  (str xml-tag
       (html {:mode :xml}
             (insert-at
              alert-template
              :alertTemplate
              [:title title][:description desc]))))

(defn ^:export createAlert
  "Externalized entry point for Apple TV testing"
  [title description]
    (.parseFromString
     (js/DOMParser.)
     (tv-alert title description) "application/xml"))


(tv-alert "foo" "bar")
