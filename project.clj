(defproject tvtest "0.1.0-SNAPSHOT"
  :description "Sample Clojure, Compojure, Clojurescript and TVML/TVJS code"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [hiccups "0.3.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.2"]]
  :ring {:handler tvtest.handler/app}
  :hooks [leiningen.cljsbuild]

  :source-paths ["src/clj"]

  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {
                                   :output-to "resources/public/js/core.js"
                                   :optimizations :whitespace
                                   ;:language-in :ecmascript5
                                   ;:language-out :ecmascript5
                                   :pretty-print true}}
                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {
                                   :output-to "resources/public/js/core.js"
                                   :optimizations :none
                                   ;:language-in :ecmascript5
                                   ;:language-out :ecmascript5
                                   :pretty-print false}}]
              }

  :profiles {
             :dev {
                   :dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]
                   }
             }
  )
