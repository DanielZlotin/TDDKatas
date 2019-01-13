#!/usr/bin/env bash -e

go test -coverprofile=coverage.out ./...
go tool cover -html=coverage.out
rm coverage.out
