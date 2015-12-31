# tvtest

Simple example of calling Clojure/Compojure/ClojureScript codes from the
Apple TVOS SDK.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running (Local with XCode TV Emaulator)

1. From the command line, in the tvtest project directory, run:

    `lein ring server`

2. In XCode, assuming the AppDelegate is in Swift, set the following:
````
    static let TVBaseURL = "http://localhost:3000/"
    static let TVBootURL = "\(AppDelegate.TVBaseURL)js/application.js"
````

3. Click the XCode Run button to start the emulator

## License

Copyright © 2015 FIXME
