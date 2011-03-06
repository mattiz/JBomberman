#!/bin/bash

cd target
java -cp "lib/*" -Djava.library.path=natives org.moogirc.jbomberman.JBomberman
