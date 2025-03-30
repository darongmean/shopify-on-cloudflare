(ns init-project
  (:require
    ["readline-sync" :as readline-sync]
    [promesa.core :as p]))

(println "Follow the following steps to initialize your project:")

(p/let
  [_
   (do (println "You should create shopify.app.production.toml ...")
       (println "TIP: try the following command:")
       (println "npx shopify app config link --config production")
       (println "See https://shopify.dev/docs/apps/build/cli-for-apps/manage-app-config-files")
       (.question readline-sync "done?"))

   _
   (do (println "You should create shopify.app.development.toml ...")
       (println "TIP: try the following command:")
       (println "npx shopify app config link --config development")
       (println "See https://shopify.dev/docs/apps/build/cli-for-apps/manage-app-config-files")
       (.question readline-sync "done?"))

   _
  (do (println "You should create wrangler.toml ...")
      (println "TIP: copy from file wrangler.example.toml")
      (println "See https://developers.cloudflare.com/workers/wrangler/configuration/")
      (println "See https://developers.cloudflare.com/workers/wrangler/environments/")
      (.question readline-sync "done?"))]

  (println "DONE"))
