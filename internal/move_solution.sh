#!/bin/bash

echo "INFO: Move solution and its branch on top of master"

git switch master
git pull --rebase
git rebase master solution --update-refs
git branch | grep -v master | grep -v solution | xargs -I {} git --verbose push origin {}
git push origin solution
git switch master
echo "👍"
