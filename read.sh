#! /usr/bin/env bash

pkill evince
evince docs/design-patterns.pdf >/dev/null 2>&1 & disown
