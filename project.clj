(defproject arachne-mail "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.arachne-framework/arachne-core "0.1.0-master-0066-45e67ab"]
                 [com.datomic/datomic-free "0.9.5350"
                   :exclusions [org.slf4j/slf4j-api
                      org.slf4j/slf4j-nop
                      org.slf4j/slf4j-log4j12
                      org.slf4j/log4j-over-slf4j]]]

  :repositories [["arachne-dev" "http://maven.arachne-framework.org/artifactory/arachne-dev"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}})
