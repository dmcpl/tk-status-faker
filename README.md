# tk-status-faker

A trapperkeeper web app designed to ... well, that part is up to you.

## Usage

First, run:

    $ lein tk

Then, hit: `http://localhost:6969/status/v1/services`

### Running from the REPL

Alternately, run:

    $ lein repl
    nREPL server started on port 52137 on host 127.0.0.1
    user => (go)

This will allow you to launch the app from the Clojure REPL. You can then make
changes and run `(reset)` to reload the app or `(stop)` to shutdown the app.

In addition, the functions `(context)` and `(print-context)` are available to
print out the current trapperkeeper application context. Both of these take an
optional array of keys as a parameter, which is used to retrieve a nested
subset of the context map.

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
