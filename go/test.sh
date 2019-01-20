#!/usr/bin/env bash -e

gofmt -s -l -w ./
goimports -l -w ./
go vet -all ./...
go build ./...
go test -vet '' ./...

#go test ./... -bench .
#go test ./... --race
