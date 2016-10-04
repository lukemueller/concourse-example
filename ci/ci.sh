#!/usr/bin/env bash

echo Hello World
echo `pwd`
echo `ls -la`

pushd concourse-example
    ./gradlew addition:clean addition:test
popd