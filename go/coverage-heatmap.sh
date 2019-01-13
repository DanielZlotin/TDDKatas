#!/usr/bin/env bash -e

go test -coverprofile=coverage.out -covermode=count ./...
go tool cover -html=coverage.out
rm coverage.out
