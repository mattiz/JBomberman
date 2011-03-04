#!/bin/bash

java -cp "target/lib/*" -Djava.library.path=target/natives/ org.moogirc.jbomberman.JBomberman
