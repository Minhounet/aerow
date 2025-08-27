#!/bin/bash

echo "INFO: Move solution and its branch on top of master"

git switch master
git pull --rebase
git rebase master solution --update-refs
git branch | grep -v master | grep -v solution | xargs -I {} git push origin {} --force-with-lease
git push origin solution --force-with-lease
git switch master
echo "👍"
