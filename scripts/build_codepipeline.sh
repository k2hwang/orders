#!/usr/bin/env bash
IMAGE=orders

set -ev

SCRIPT_DIR=$(dirname "$0")

CODE_DIR=$(cd $SCRIPT_DIR/..; pwd)
echo $CODE_DIR

cp -r $CODE_DIR/docker $CODE_DIR/target/docker/
cp -r $CODE_DIR/target/*.jar $CODE_DIR/target/docker/${IMAGE}

docker build -t $REPOSITORY_URI:$TAG $CODE_DIR/target/docker/${IMAGE};
