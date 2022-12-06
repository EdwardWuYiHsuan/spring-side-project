#!/bin/bash

project_name=$(pwd | sed 's/.*\/workspace\///g' | cut -f1 -d"/")
#git_repository=$(git config --get remote.origin.url | sed 's/:/\//g' | sed 's/git@/https:\/\//g' | sed 's/\.git//g')
git_repository=$(git config --get remote.origin.url)
git_branch=$(git branch --show-current)
git_commit=$(git log -1 --pretty=format:%h)

echo Project = ${project_name}
echo Repository = ${git_repository}
echo Branch = ${git_branch} 
echo Commit = ${git_commit}
