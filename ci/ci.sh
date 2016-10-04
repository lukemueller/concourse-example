#!/usr/bin/env bash

pushd concourse-example
    echo `pwd`
    echo `ls -la`
    ./gradlew addition:clean addition:test
popd