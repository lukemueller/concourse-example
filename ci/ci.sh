#!/usr/bin/env bash

pushd concourse-example
    ./gradlew addition:clean addition:test
popd