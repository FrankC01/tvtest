(ns tvtest.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "<h1>Hello World</h1")
  (route/resources "public")
  (route/not-found "<h1>Resource you are looking for is not found</h1>"))

(def app
  (wrap-defaults app-routes site-defaults))
