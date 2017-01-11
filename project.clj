;; WARNING: this file is automatically generated for Cursive compatibility
 ;; Edit project.edn or build.boot if you want to modify the real configuration
(defproject
  org.arachne-framework/arachne-mailer
  "0.1.0-converting-to-boot-0005-389675f"
  :dependencies
  [[org.clojure/clojure "1.9.0-alpha14" :scope "provided"]
   [org.arachne-framework/arachne-core "0.1.0-master-0062-a6074e6"]]
  :source-paths
  #{"src" "resources"}
  :test-paths
  #{"dev" "test"}
  :profiles
  {:dev
   {:dependencies
    [[adzerk/boot-test "1.1.2" :scope "test"]
     [org.clojure/test.check "0.9.0" :scope "test"]
     [org.clojure/tools.namespace "0.2.11" :scope "test"]
     [datascript "0.15.3" :scope "test"]
     [com.datomic/datomic-free
      "0.9.5350"
      :exclusions
      [org.slf4j/slf4j-log4j12
       org.slf4j/slf4j-nop
       org.slf4j/slf4j-api
       org.slf4j/log4j-over-slf4j]
      :scope
      "test"]
     [ch.qos.logback/logback-classic "1.1.3" :scope "test"]
     [org.slf4j/jul-to-slf4j
      "1.7.12"
      :exclusions
      [org.slf4j/slf4j-api]
      :scope
      "test"]
     [org.slf4j/jcl-over-slf4j "1.7.12" :scope "test"]
     [org.slf4j/log4j-over-slf4j "1.7.12" :scope "test"]],
    :source-paths #{"dev"}}})