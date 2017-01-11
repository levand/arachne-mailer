#_(set-env! 
  :source-paths #{"src" "test"}
  :dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                 [org.arachne-framework/arachne-core "0.1.0-master-0066-45e67ab"]
                 [Com.datomic/datomic-free "0.9.5350"
                   :exclusions [org.slf4j/slf4j-api
                      org.slf4j/slf4j-nop
                      org.slf4j/slf4j-log4j12
                      org.slf4j/log4j-over-slf4j]]
                 [adzerk/boot-test "1.1.2" :scope "test"]]
 
  :repositories #(conj % ["arachne-dev" {:url "http://maven.arachne-framework.org/artifactory/arachne-dev"}])
)

(set-env! :repositories
  #(conj % ["arachne-dev" {:url "http://maven.arachne-framework.org/artifactory/arachne-dev"}]))

(set-env!
  :dependencies
  `[[org.arachne-framework/arachne-buildtools "0.2.4-master-0028-7a76bc6" :scope "test"]])

(require '[arachne.buildtools :refer :all])

(read-project-edn!)
